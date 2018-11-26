package Exp3;

import java.util.ArrayList;

import static Exp3.Coefficients.*;
import static Exp3.Forecasting.printForecastedValues;
import static Exp3.UpdatedTimeSeria.getUpdatedTimeSeria;

public class RunApplication {


	public static ArrayList<TimeSeria> timeSeria = new ArrayList<TimeSeria>();
	public static ArrayList<UpdatedTimeSeria> updatedTimeSerias = new ArrayList<UpdatedTimeSeria>();
	public static ArrayList<Double> realResult = new ArrayList<>();
	public static ArrayList<Double> forecastResult = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		ReadFromFile.openFile(timeSeria, realResult);
		System.out.println("Alfa= " + ALFA + ", Betta=  " + BETTA + ", Gamma=  " + GAMMA + ", Season=  " + L);
		InitialIndexis initialIndexis = new InitialIndexis();
		initialIndexis.formS0();
		initialIndexis.formB0();
		initialIndexis.formC0();
		System.out.println("s0 " + initialIndexis.getS0() + "\n" + "b0 " + initialIndexis.getB0() + "\n" + "c0 " + initialIndexis.getC0());
		FormattedIndexis formattedIndexis = new FormattedIndexis();
		for (int i = 1; i <= timeSeria.size(); i++) {
			formattedIndexis.formSt(i);
		}
		getUpdatedTimeSeria();
		WriteToFile.writeToFile(updatedTimeSerias, "Updated St, Bt, Ct");
		Forecasting forecasting = new Forecasting();
		forecasting.getForecastedValues(updatedTimeSerias, 4);
		printForecastedValues(forecastResult);
		WriteToFile.writeToFile(forecastResult, "Forecasted values : ");
		//	ErrorCoeficients.getMSE(realResult, forecastResult);
		//	ErrorCoeficients.getE(realResult, forecastResult);
	}
}
