package GA;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.TreeMap;

import static GA.GAparametrs.POPULATION;
import static sample.Controller.getFitness;

public class NewPopulation {
    public static ArrayList<Xromocoma> selectedXromocomaInNewPopulation = new ArrayList<>();

    public static ArrayList<Xromocoma> formNewPopulation(ArrayList<Xromocoma> parents, ArrayList<Xromocoma> children) {
        ArrayList<Xromocoma> generalList = new ArrayList<>();
        generalList.addAll(parents);
        generalList.addAll(children);
        return generalList;
    }

    public static ArrayList<Xromocoma> selectXromocomaInNewPopulation(ArrayList<Xromocoma> list) {
        selectedXromocomaInNewPopulation.clear();
        ArrayList<Double> fintessList = new ArrayList<>();
        double fitnessValue = 0.0;
        TreeMap<Double, Xromocoma> map = new TreeMap<>();
        System.out.println("Хромосомы:дети+родители:      и  Фитнес-Функция");
        for (int i = 0; i < list.size(); i++) {
            fitnessValue = getFitness(list.get(i).getAlfa(), list.get(i).getBetta(), list.get(i).getGamma());
            System.out.println(list.get(i) + " :" + new DecimalFormat("#0.000").format(fitnessValue));
            fintessList.add(fitnessValue);
            map.put(fitnessValue, list.get(i));
        }
        int j = 0;
        System.out.println("Лучшие хромосомы: ");
        double averageGhildFitnessValue = 0.0;
        double sum = 0.0;
        for (Double k : map.keySet()) {
            sum += k;
        }
        averageGhildFitnessValue = sum / POPULATION;
        System.out.println("Среднее значение потомков фитнесс-функции:  " + averageGhildFitnessValue);
        for (Double k : map.keySet()) {
            if (j < POPULATION) {
                selectedXromocomaInNewPopulation.add(new Xromocoma(map.get(k).getAlfa(), map.get(k).getBetta(), map.get(k).getGamma()));
                System.out.println(selectedXromocomaInNewPopulation.get(j));
            }
            j++;
        }
        return selectedXromocomaInNewPopulation;
    }
}
