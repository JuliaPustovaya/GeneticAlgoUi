package GA;

import Exp3.InitialIndexis;
import Exp3.TimeSeria;
import Exp3.UpdatedTimeSeria;

import java.util.ArrayList;

public class RunGAApplication {
	public static ArrayList<TimeSeria> timeSeria = new ArrayList<TimeSeria>();
	public static ArrayList<UpdatedTimeSeria> updatedTimeSerias = new ArrayList<UpdatedTimeSeria>();
	public static ArrayList<Double> forecastResult = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		//	ReadFromFile.openFile(timeSeria);
		InitialIndexis initialIndexis = new InitialIndexis();
		initialIndexis.formS0();
		System.out.println("s0 " + initialIndexis.getS0());
		initialIndexis.formB0();
		System.out.println("b0 " + initialIndexis.getB0());
		initialIndexis.formC0();
		System.out.println("c0 " + initialIndexis.getC0());
		Population p = new Population();
		p.makeRandomPopulation(0.0, 1.1);
		System.out.println(Population.populationXromocoma);
	}
}
