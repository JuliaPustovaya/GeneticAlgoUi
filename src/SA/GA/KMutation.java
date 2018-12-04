package SA.GA;

import java.util.ArrayList;
import java.util.Random;

import static SA.GA.KGAparametrs.POPULATION;
import static SA.GA.KGAparametrs.PROBALITY_MUTATON;

public class KMutation {
	public static ArrayList<KXromocoma> childrenAfterMutation = new ArrayList<>();

	public static ArrayList<KXromocoma> RandomMutation(ArrayList<KXromocoma> list) {
		childrenAfterMutation.clear();
		for (int i = 0; i < list.size(); i++) {
			if (new Random().nextDouble() > PROBALITY_MUTATON) {
				Random random = new Random();
				int numberOfModifiedGene = random.nextInt();
				if (numberOfModifiedGene == 0) {
					int res = getModifiedGene(list.get(i).getAlfa(), i);
					list.get(i).setAlfa(res);
				} else   {
					int res = getModifiedGene(list.get(i).getBetta(), i);
					list.get(i).setBetta(res);
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

	public static int getModifiedGene(double value, int numberOfCurrentXromocoma) {
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
		return (int) result;
	}
}
