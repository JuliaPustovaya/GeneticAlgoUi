package GA;

import static GA.GAparametrs.POPULATION;
import static GA.GAparametrs.QUANTITYOfGen;
import static GA.RunGAApplication.getFitness;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Population {
	public static ArrayList<Xromocoma> populationXromocoma = new ArrayList<>();
	public static ArrayList<Xromocoma> selectedParentsForSelection = new ArrayList<>();

	public static void makeRandomPopulation() {
		for (int i = 0; i < POPULATION; i++) {
			Xromocoma xromocoma = new Xromocoma();
			for (int j = 0; j < QUANTITYOfGen; j++) {
				xromocoma.setAlfa(Math.random());
				xromocoma.setBetta(Math.random());
				xromocoma.setGamma(Math.random());
			}
			populationXromocoma.add(xromocoma);
		}
		System.out.println(" Сгенерированные хромосомы ");
		for (int i = 0; i < populationXromocoma.size(); i++) {
			System.out.println(populationXromocoma.get(i));
		}
	}

	/**
	 * Для каждой хромосомы считаем фитнес-функция  resultListOfFitness
	 * Получаем общую сумму значений  фитнесс-функции всех хромосом sumOfFitnessFunction
	 * Формируем список вероятностей выбора данной хромосомы для участия в селекции   probalities
	 * Реализация метода рулеки.Возвращает номер хромосомы выбранной для участия в скрещивании
	 * Результирующий список с хромосомами выбраными для селекции    selectedParentsForSelection(без повторений)
	 */

	public static ArrayList<Xromocoma> makeRuletSelection() {
		ArrayList<Double> resultListOfFitness = new ArrayList<>();
		double sumOfFitnessFunction = 0;
		for (int i = 0; i < POPULATION; i++) {
			resultListOfFitness.add(getFitness(populationXromocoma.get(i).getAlfa(), populationXromocoma.get(i).getBetta(),
					populationXromocoma.get(i).getGamma()));
			sumOfFitnessFunction += resultListOfFitness.get(i);
		}
		System.out.println("Значение фитнес-функций: ");
		resultListOfFitness.forEach(System.out::println);
		System.out.println("Общая сумма фитнес-функций: " + sumOfFitnessFunction);
		double previous_probability = 0.0;
		ArrayList<Double> probalities = new ArrayList<>();
		for (int i = 0; i < resultListOfFitness.size(); i++) {
			previous_probability = previous_probability + (resultListOfFitness.get(i) / sumOfFitnessFunction);
			probalities.add(previous_probability);
		}
		System.out.println("Возможности попадания в сектор: " + probalities);
		for (int i = 0; i < POPULATION; i++) {
			Random random = new Random();
			double randomValue = random.nextDouble();
			int idexOfChoosenXromocoma = selectIndividumForSelection(randomValue, probalities);
			if (!selectedParentsForSelection.contains(populationXromocoma.get(idexOfChoosenXromocoma))) {
				selectedParentsForSelection.add(populationXromocoma.get(idexOfChoosenXromocoma));
			}
			System.out.println("Fitness Function: " + new DecimalFormat("#0.0000").format(resultListOfFitness.get(idexOfChoosenXromocoma))
					+ " рандомное число :" + new DecimalFormat("#0.0000").format(randomValue) + ";  номер сектора :  " +
					idexOfChoosenXromocoma);
		}
		System.out.println("Родители для селекции: " + selectedParentsForSelection);
		return selectedParentsForSelection;
	}

	public static int selectIndividumForSelection(double random, ArrayList<Double> probabilityList) {
		int index = -1;
		for (int i = 0; i < POPULATION; i++) {
			while (random < probabilityList.get(i)) {
				if (i == 0) {
					return i;
				} else {
					index = i - 1;
				}
				return index;
			}
		}
		return index;
	}
}