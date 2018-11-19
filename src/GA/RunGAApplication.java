package GA;

import java.util.ArrayList;

import Exp3.InitialIndexis;
import Exp3.TimeSeria;
import Exp3.UpdatedTimeSeria;

public class RunGAApplication {
	public static ArrayList<TimeSeria> timeSeria = new ArrayList<TimeSeria>();
	public static ArrayList<UpdatedTimeSeria> updatedTimeSerias = new ArrayList<UpdatedTimeSeria>();
	public static ArrayList<Double> forecastResult = new ArrayList<>();

	//
	public static double getFitness(double alfa, double beta, double gama) {
		return Math.random();
	}


	public static void main(String[] args) throws Exception {
		//	ReadFromFile.openFile(timeSeria);
//		InitialIndexis initialIndexis = new InitialIndexis();
//		initialIndexis.formS0();
//		System.out.println("s0 " + initialIndexis.getS0());
//		initialIndexis.formB0();
//		System.out.println("b0 " + initialIndexis.getB0());
//		initialIndexis.formC0();
//		System.out.println("c0 " + initialIndexis.getC0());

		Population.makeRandomPopulation();
		System.out.println(Population.populationXromocoma);
		Population.makeRuletSelection();
		Selection.getParentsPairsForSelections(Population.selectedParentsForSelection);
		Crossover crossover= new Crossover();
		crossover.getChidrenPairsOnePointCrossover(Selection.parentsPairsForSelections);

	}
}
