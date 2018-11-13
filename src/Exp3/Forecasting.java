package Exp3;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static Exp3.Coefficients.L;
import static sample.Main.forecastResult;

public class Forecasting {
	public ArrayList<Double> getForecastedValues(ArrayList<UpdatedTimeSeria> StList, int m) {
		int t = StList.size();
		for (int i = 1; i <= m; i++) {
			int m1 = (i > L) ? (i % L) : i;
			double temp = (StList.get(t - 1).getsT() + i * StList.get(t - 1).getbT()) * StList.get(t - L + m1 - 1).getcT();
			forecastResult.add(temp);
		}
		return forecastResult;
	}

	public static void printForecastedValues(ArrayList<Double> list) {
		System.out.println("Foretasted values:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("i= " + (i+1) + " value= " + new DecimalFormat("#0.000").format(list.get(i)));
		}
	}
}
