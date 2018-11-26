package GA;

import static GA.GAparametrs.POPULATION;
import static GA.GAparametrs.PROBALITY_MUTATON;

import java.util.ArrayList;
import java.util.Random;

public class Mutation {
	public static ArrayList<Xromocoma> childrenAfterMutation = new ArrayList<>();

	public static ArrayList<Xromocoma> RandomMutation(ArrayList<Xromocoma> list) {
		for (int i = 0; i < list.size(); i++) {
			if (new Random().nextDouble() > PROBALITY_MUTATON) {
				Random random = new Random();
				int numberOfModifiedGene = random.nextInt() + 3;
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
		}
		System.out.println("Modified+Non-modified потомки ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		childrenAfterMutation.addAll(list);
		return childrenAfterMutation;
	}

	public static double getModifiedGene(double value, int numberOfCurrentXromocoma) {
		double a1 = new Random().nextDouble();
		double a2 = new Random().nextDouble();
		double result = 0.0;
		double r = new Random().nextDouble();
		int valueMax = 1;
		int valueMin = 0;
		if (a1 < 0.5) {
			result = value + (valueMax - value) * (a2 * (1 - (numberOfCurrentXromocoma + 1) / (double) POPULATION));
		} else {
			result = value - (value + valueMin) * (a2 * (1 - (numberOfCurrentXromocoma + 1) / (double) POPULATION));
		}
		return result;
	}
}
