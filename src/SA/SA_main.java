package SA;

import Exp3.ReadFromFile;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SA_main {
    public static ArrayList<Double> X_list_SA;
    public static ArrayList<Double> X_list_SA_EVKLIDOV = new ArrayList<>();

    public static ArrayList<ArrayList<Double>> Z_list_vector_history = new ArrayList<>();
    public static ArrayList<Double> e_distance = new ArrayList<>();

    public static ArrayList<ArrayList<Double>> Z_last_e_vector_history = new ArrayList<>();

    public static ArrayList<Double> e_nearest_distance = new ArrayList<>();
    public Double e_dis_nearest;

    public ArrayList<ArrayList<Double>> Z_list_vector_history_evklidov;

    public static ArrayList<ArrayList<Double>> getZ_list_vector_history() {
        return Z_list_vector_history;
    }

    public ArrayList<Map.Entry<Integer, Double>> Z_sorted_distance_Evklid_SA;

    public TreeMap<Integer, Double> nn_Evklid_SA;
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

class RunAll {
    public static ArrayList<Double> datafromfile = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        SA.SA_main.X_list_SA = new ArrayList();
        int amountForecasting = 4;
        int K = 4;
        int M = 4;
        ReadDataFromFile.openFile();
        for (int i = 0; i < datafromfile.size() - amountForecasting; i++) {
            SA.SA_main.X_list_SA.add(datafromfile.get(i));
        }
        SA.SA_main.X_list_SA_EVKLIDOV.addAll(SA.SA_main.X_list_SA);
        SA.SA_main SA = new SA_main();
        for (int i = 0; i < amountForecasting; i++) {
            SA.Z_list_vector_history_evklidov = ReadDataFromFile.FormListOfZ_vector_histories(SA_main.X_list_SA_EVKLIDOV, M);
            SA.Z_sorted_distance_Evklid_SA = ReadDataFromFile.Evklidova_distance(SA.Z_list_vector_history_evklidov);
            SA.nn_Evklid_SA = ReadDataFromFile.pois_K_nearest(SA.Z_sorted_distance_Evklid_SA, K);
            SA.poisk_next_forecasting_meaning(SA.nn_Evklid_SA, SA.Z_list_vector_history_evklidov, SA_main.X_list_SA_EVKLIDOV);
        }
        System.out.println("Forecasted: "+ SA_main.X_list_SA_EVKLIDOV);
        System.out.println( MSE(SA_main.X_list_SA_EVKLIDOV, datafromfile, K));
    }
    public static String MSE(ArrayList<Double> ar_origin, ArrayList<Double> ar_for, int k) {
        double sum = 0;
        for (int i = ar_for.size() - 1; i >= ar_for.size() - k; i--) {
            sum = sum + Math.pow((ar_for.get(i) - ar_origin.get(i)),2);
        }
        Double d=((double) sum / (double) k);
        return d.toString() ;
    }
}

