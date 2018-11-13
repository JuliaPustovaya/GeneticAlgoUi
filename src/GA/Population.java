package GA;

import java.util.ArrayList;

import static GA.GAparametrs.POPULATION;
import static GA.GAparametrs.quantityOfGen;

public class Population {
	public static ArrayList<Xromocoma> populationXromocoma = new ArrayList<>();

	public void makeRandomPopulation(double val1, double val2) {
		for (int i = 0; i < POPULATION; i++) {
			Xromocoma xromocoma = new Xromocoma();
			for (int j = 0; j < quantityOfGen; j++) {
				xromocoma.setAlfa(Math.random());
				xromocoma.setBetta(Math.random());
				xromocoma.setGamma(Math.random());
			}
			populationXromocoma.add(xromocoma);
		}
	}
	//	public  ArrayList<Xromocoma> makeRuletSelection() {
	//
	//	}
	//
	//	public Double getFitnessForEachXromocome(){
	//
	//
	//	}
}
