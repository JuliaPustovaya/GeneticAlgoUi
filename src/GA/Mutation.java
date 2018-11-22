package GA;

import static GA.GAparametrs.POPULATION;

import java.util.ArrayList;
import java.util.Random;
               
public class Mutation {
	public static ArrayList<Xromocoma> childrenAfterMutation = new ArrayList<Xromocoma>();

	public static ArrayList<Xromocoma> RandomMutation(ArrayList<Xromocoma> list) {
		Random random = new Random();
		int numberOfModifiedGene = random.nextInt() + 3;
		for (int i = 0; i < list.size(); i++) {
			if (numberOfModifiedGene == 0) {
				double res = getModifiedGene(list.get(i).getAlfa(), i);
				list.get(i).setAlfa(res);
			} else if (numberOfModifiedGene == 1) {
				double res = getModifiedGene(list.get(i).getBetta(), i);
				list.get(i).setBetta(res);
			} else {
				double res = getModifiedGene(list.get(i).getGamma(), i);
				list.get(i).setGamma(res);
			}
		}
		System.out.println("Модифицированные потомки " + list);
		return list;
	}

	public static double getModifiedGene(double value, int numberOfCurrentXromocoma) {
		double result = 0.0;
		Random random = new Random();
		double r = random.nextDouble();
		int valueMax = 1;
		int valueMin = 0;
		if (r > 0.5) {
			result = value + (valueMax-value) * r * (1.0 - Math.pow((numberOfCurrentXromocoma / POPULATION), 2));
		} else {
			result = value + (value-valueMin) * r * (1.0 - Math.pow((numberOfCurrentXromocoma / POPULATION), 2));
		}
		return result;
	}
}
