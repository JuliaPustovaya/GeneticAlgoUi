package GA;

import static GA.GAparametrs.POPULATION;
import static GA.GAparametrs.quantityOfGen;
import static GA.RunGAApplication.getFitness;

import java.util.ArrayList;
import java.util.Random;

public class Population {
	public static ArrayList<Xromocoma> populationXromocoma = new ArrayList<>();

	public static void makeRandomPopulation() {
		for (int i = 0; i < POPULATION; i++) {
			Xromocoma xromocoma = new Xromocoma();
			for (int j = 0; j < quantityOfGen; j++) {
				xromocoma.setAlfa(Math.random());
				xromocoma.setBetta(Math.random());
				xromocoma.setGamma(Math.random());
			}
			populationXromocoma.add(xromocoma);
		}
	}

	/**
	 * Для каждой хромосомы считаем фитнес-функция  resultListOfFitness
	 * Получаем общую сумму значений  фитнесс-функции всех хромосом sumOfFitnessFunction
	 * Формируем список вероятностей выбора данной хромосомы для участия в селекции   probabilityOfBeingChoosenParentForSelection
	 * Реализация метода рулеки.Возвращает номер хромосомы выбранной для участия в скрещивании
	 * Результирующий список с хромосомами выбраными для селекции    selectedParentsForSelection(без повторений)
	 */

	public static ArrayList<Xromocoma> makeRuletSelection() {
		ArrayList<Double> resultListOfFitness = new ArrayList<>();
		double sumOfFitnessFunction = 0;
		ArrayList<Double> probabilityOfBeingChoosenParentForSelection = new ArrayList<>();
		ArrayList<Xromocoma> selectedParentsForSelection = new ArrayList<>();
		for (int i = 0; i < POPULATION; i++) {
			resultListOfFitness.add(getFitness(populationXromocoma.get(i).getAlfa(), populationXromocoma.get(i).getBetta(),
					populationXromocoma.get(i).getGamma()));
			sumOfFitnessFunction += resultListOfFitness.get(i);
		}
		System.out.println("Значение фитнес-функций: ");
		resultListOfFitness.forEach(System.out::println);
		System.out.println("Общая сумма фитнес-функций: " + sumOfFitnessFunction);
		for (int i = 0; i < resultListOfFitness.size(); i++) {
			probabilityOfBeingChoosenParentForSelection.add((resultListOfFitness.get(i) / sumOfFitnessFunction));
		}
		for (int i = 0; i < POPULATION; i++) {
			Random random = new Random();
			double randomValue = 0.0 + (sumOfFitnessFunction - 0.0) * random.nextDouble();
			System.out.println("рандомное число :" + randomValue);
			int idexOfChoosenXromocoma = selectIndividumForSelection(randomValue, probabilityOfBeingChoosenParentForSelection);
			System.out.println("номер сектора :  " + idexOfChoosenXromocoma);
			if (!selectedParentsForSelection.contains(populationXromocoma.get(idexOfChoosenXromocoma))) {
				selectedParentsForSelection.add(populationXromocoma.get(idexOfChoosenXromocoma));
			}
		}
		return selectedParentsForSelection;
	}

	public static int selectIndividumForSelection(double random, ArrayList<Double> probabilityList) {
		int index = 0;
		double tempsum = 0;
		for (int i = 0; i < probabilityList.size(); i++) {
			tempsum = tempsum + probabilityList.get(i);
			if (random <= tempsum) {
				index = i;
			}
		}
		return index;
	}
}