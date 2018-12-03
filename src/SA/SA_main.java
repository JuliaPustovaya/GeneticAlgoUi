package SA;

import Exp3.ReadFromFile;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SA_main {
    public static ArrayList<Double> X_list_SA = new ArrayList<>();
    public static ArrayList<Double> X_list_SA_EVKLIDOV = new ArrayList<>();

    public static ArrayList<ArrayList<Double>> Z_list_vector_history = new ArrayList<>();
    public static ArrayList<Double> e_distance = new ArrayList<>();

    public ArrayList<ArrayList<Double>> Z_list_vector_history_evklidov = new ArrayList<>();

    public ArrayList<Map.Entry<Integer, Double>> Z_sorted_distance_Evklid_SA = new ArrayList<>();

    public TreeMap<Integer, Double> nn_Evklid_SA = new TreeMap<>();
    public static Integer I = 0;

    public void poisk_next_forecasting_meaning(TreeMap<Integer, Double> nn, ArrayList<ArrayList<Double>> Z_list_vector_history, ArrayList<Double> LISTOFFORECASTINGMEANINGS) {
        ArrayList<Double> Ti_plus1_list = new ArrayList<>();
        double sum = 0;
        for (int i : nn.keySet()) {
            double q = Z_list_vector_history.get(i + 1).get(Z_list_vector_history.get(i + 1).size() - 1);
            Ti_plus1_list.add(q);
            sum = sum + q;
        }
        System.out.println("forecasting eleement =" + (double) sum / nn.size());
        LISTOFFORECASTINGMEANINGS.add((double) sum / nn.size());

    }

}



