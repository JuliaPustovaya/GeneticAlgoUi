package Exp3;

import java.util.ArrayList;

public class ErrorCoeficients {
    public static double MSE = 0.0;                             //среднеквадратическая ошибка
    public static double E = 0.0;

    public static double getMSE(ArrayList<Double> initial, ArrayList<Double> forecasted) {
        Double temp = 0.0;
        for (int i = 0; i < initial.size(); i++) {
            temp += Math.pow((initial.get(i) - forecasted.get(i)), 2);

        }
        MSE = (temp / (double) initial.size());
        System.out.println("Среднеквадратическая ошибка:  " + Math.sqrt(MSE));
        return  Math.sqrt(MSE);
    }

    public static double getE(ArrayList<Double> initial, ArrayList<Double> forecasted) {   //среднюю ошибку аппроксимации
        Double temp = 0.0;
        for (int i = 0; i < initial.size(); i++) {
            double a = (Math.abs(initial.get(i) - forecasted.get(i)) / initial.get(i)) * 100;
            temp = temp + a;
        }
        E = (1.0 / (double) initial.size()) * temp;
        System.out.println("Средняя ошибка:  " + E);
        return E;
    }
}
