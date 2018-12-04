package SA.GA;

import sample.Controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.TreeMap;

import static SA.GA.KGAparametrs.POPULATION;
import static sample.Controller.getFitness;

public class KNewPopulation {
    public static ArrayList<KXromocoma> selectedXromocomaInNewPopulation = new ArrayList<>();

    public static ArrayList<KXromocoma> formNewPopulation(ArrayList<KXromocoma> parents, ArrayList<KXromocoma> children) {
        ArrayList<KXromocoma> generalList = new ArrayList<>();
        generalList.addAll(parents);
        generalList.addAll(children);
        return generalList;
    }

    public static ArrayList<KXromocoma> selectXromocomaInNewPopulation(ArrayList<KXromocoma> list) {
        selectedXromocomaInNewPopulation.clear();
        ArrayList<Double> fintessList = new ArrayList<>();
        double fitnessValue = 0.0;
        TreeMap<Double, KXromocoma> map = new TreeMap<>();
        System.out.println("Хромосомы:дети+родители:      и  Фитнес-Функция");
        for (int i = 0; i < list.size(); i++) {
            fitnessValue = getFitness(list.get(i).getAlfa(), list.get(i).getBetta());
            System.out.println(list.get(i) + " :!" + new DecimalFormat("#0.000").format(fitnessValue));
            fintessList.add(fitnessValue);
            Controller.resKNearestKxromocoma=new KXromocoma(list.get(i).getAlfa(),list.get(i).getBetta());
            map.put(fitnessValue, list.get(i));
        }
        int j = 0;

        double averageGhildFitnessValue = 0.0;
        double sum = 0.0;
        for (Double k : map.keySet()) {
            sum += k;
        }
        averageGhildFitnessValue = sum / POPULATION;
        System.out.println("Среднее значение потомков фитнесс-функции:  " + averageGhildFitnessValue);
        for (Double k : map.keySet()) {
            if (j < POPULATION) {
                selectedXromocomaInNewPopulation.add(new KXromocoma(map.get(k).getAlfa(), map.get(k).getBetta()));
                System.out.println(selectedXromocomaInNewPopulation.get(j));
            }
            j++;
        }
        return selectedXromocomaInNewPopulation;
    }
}
