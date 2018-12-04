package SA.GA;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

import static SA.GA.KGAparametrs.POPULATION;
import static SA.GA.KGAparametrs.QUANTITYOfGen;
import static sample.Controller.getFitness;

public class KPopulation {
    public static ArrayList<KXromocoma> populationXromocoma = new ArrayList<>();
    public static ArrayList<KXromocoma> selectedParentsForSelection = new ArrayList<>();

    public static void makeRandomPopulation() {
        populationXromocoma.clear();
        for (int i = 0; i < POPULATION; i++) {
            KXromocoma xromocoma = new KXromocoma();
            for (int j = 0; j < QUANTITYOfGen; j++) {
                //(b-a+1)+a
                xromocoma.setBetta((int) (Math.random() * (KGAparametrs.N-2) + 1));//m- long vector-history
                xromocoma.setAlfa((int) (Math.random() * ( KGAparametrs.N-xromocoma.getBetta())) + 1);//k-nearest


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

    public static ArrayList<KXromocoma> makeRuletSelection() {
        selectedParentsForSelection.clear();
        ArrayList<Double> resultListOfFitness = new ArrayList<>();
        double sumOfFitnessFunction = 0;
        for (int i = 0; i < POPULATION; i++) {
            resultListOfFitness.add(getFitness(populationXromocoma.get(i).getAlfa(), populationXromocoma.get(i).getBetta()));
            sumOfFitnessFunction += resultListOfFitness.get(i);
        }
        System.out.println("Значение фитнес-функций: ");
        resultListOfFitness.forEach(System.out::println);
        System.out.println("Общая сумма фитнес-функций: " + sumOfFitnessFunction);
        System.out.println("Среднее значение родителей фитнес-функций: " + sumOfFitnessFunction / POPULATION);
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
            //	if (!selectedParentsForSelection.contains(populationXromocoma.get(idexOfChoosenXromocoma))) {
            //TODO в списке отобранных родителей-хромосом могут быть дубликаты: чтобы кол-во  потомков равнялось кол-ву размеру исходной популяции
            selectedParentsForSelection.add(populationXromocoma.get(idexOfChoosenXromocoma));
            //	}
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

    public void alternativeSelection() {
        selectedParentsForSelection.clear();
        ArrayList<Double> resultListOfFitness = new ArrayList<>();
        double sumOfFitnessFunction = 0;
        for (int i = 0; i < POPULATION; i++) {
            resultListOfFitness.add(getFitness(populationXromocoma.get(i).getAlfa(), populationXromocoma.get(i).getBetta()));
            sumOfFitnessFunction += resultListOfFitness.get(i);
        }
        System.out.println("Значение фитнес-функций: ");
        TreeMap<Double, KXromocoma> map = new TreeMap<>();
        for (int i = 0; i < resultListOfFitness.size(); i++) {
            map.put(resultListOfFitness.get(i), populationXromocoma.get(i));

        }

    }

}