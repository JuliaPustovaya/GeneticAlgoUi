package Exp3;

import java.util.ArrayList;

public class ErrorCoeficients {
	public static double MSE;                             //среднеквадратическая ошибка
	public static double E;

	public static double getMSE(ArrayList<Double> initial, ArrayList<Double> forecasted) {
		Double temp = 0.0;
		for (int i = 0; i < initial.size(); i++) {
			double a = initial.get(i) - forecasted.get(i);
			temp = temp + Math.pow(a, 2);
		}
		MSE = (1.0 / (double) initial.size()) * temp;
		System.out.println("Среднеквадратическая ошибка:  " + MSE);
		return MSE;
	}

	public static double getE(ArrayList<Double> initial, ArrayList<Double> forecasted) {   //среднюю ошибку аппроксимации
		Double temp = 0.0;
		for (int i = 0; i < initial.size(); i++) {
			double a = (Math.abs(initial.get(i) - forecasted.get(i)) /forecasted.get(i)) * 100;
			temp = temp + a;
		}
		E = (1.0 / (double) initial.size()) * temp;
		System.out.println("Средняя ошибка:  " + E);
		return E;
	}
}
