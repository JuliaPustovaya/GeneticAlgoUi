package SA.GA;

import SA.ReadDataFromFile;
import SA.SA_main;

import java.util.ArrayList;

public class RunAll {
    public static ArrayList<Double> datafromfile = new ArrayList<>();
    public static double K_MSE = 0.0;

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
        System.out.println("Forecasted: " + SA_main.X_list_SA_EVKLIDOV);
        System.out.println(K_MSE(SA_main.X_list_SA_EVKLIDOV, datafromfile, K));
    }

    public static double K_MSE(ArrayList<Double> ar_origin, ArrayList<Double> ar_for, int k) {
        K_MSE = 0;
        double sum = 0;
        for (int i = ar_for.size() - 1; i >= ar_for.size() - k; i--) {
            sum = sum + Math.pow((ar_for.get(i) - ar_origin.get(i)), 2);
        }
        Double d = ((double) sum / (double) k);
        K_MSE = d;
        return d;
    }
}