package GA;

import static GA.GAparametrs.QUANTITYOfGen;
import static GA.RunGAApplication.getFitness;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class NewPopulation {
	public static ArrayList<Xromocoma> selectedXromocomaInNewPopulation = new ArrayList<>();

	public static ArrayList<Xromocoma> formNewPopulation(ArrayList<Xromocoma> parents, ArrayList<Xromocoma> children) {
		ArrayList<Xromocoma> generalList = new ArrayList<>();
		generalList.addAll(parents);
		generalList.addAll(children);
		//		System.out.println("Хромосомы:дети+родители: ");
		//		for (int i = 0; i < generalList.size(); i++) {                                       
		//			System.out.println(generalList.get(i));
		//		}
		return generalList;
	}

	public static ArrayList<Xromocoma> selectXromocomaInNewPopulation(ArrayList<Xromocoma> list) {
		ArrayList<Double> fintessList = new ArrayList<>();
		double fitnessValue = 0.0;
		TreeMap<Double, Xromocoma> map = new TreeMap<>();
		for (int i = 0; i < list.size(); i++) {
			fitnessValue = getFitness(list.get(i).getAlfa(), list.get(i).getBetta(), list.get(i).getGamma());
			fintessList.add(fitnessValue);
			//	System.out.println(" ФитнесФункция  и " + list.get(i) + "  " + fitnessValue);
			map.put(fitnessValue, list.get(i));
		}
		for (int i = 0; i < QUANTITYOfGen; i++) {
			selectedXromocomaInNewPopulation.add(new Xromocoma(map.get(i).getAlfa(),map.get(i).getBetta(),map.get(i).getGamma()));
		}
		System.out.println("\n" + "ПАРЫ " + map);
		for (int i = 0; i < selectedXromocomaInNewPopulation.size(); i++) {
			System.out.println("Лучшие хромосомы: "+selectedXromocomaInNewPopulation.get(i));
		}
		return new ArrayList<>();
	}
}
