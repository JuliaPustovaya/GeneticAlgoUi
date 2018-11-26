package GA;

import static GA.GAparametrs.QUANTITYOfGen;

import java.util.ArrayList;
import java.util.Random;

public class Crossover {

	public static ArrayList<Xromocoma> childrenListAfterCrossover = new ArrayList<>();

	/**
	 * Возвращает два потомка
	 **/
	public static ArrayList<Xromocoma> getChidrenPairsTwoPointCrossover(ArrayList<ArrayList<Xromocoma>> pairsForSelections) {
		childrenListAfterCrossover.clear();
		System.out.println("Результат кроссовера Two-point Crossover ");
		Xromocoma child1;
		Xromocoma child2;
		for (int i = 0; i < pairsForSelections.size(); i++) {
			Xromocoma xromocomaParent1 = pairsForSelections.get(i).get(0);
			Xromocoma xromocomaParent2 = pairsForSelections.get(i).get(1);
			child1 = new Xromocoma();
			child2 = new Xromocoma();
			child1.setAlfa(xromocomaParent1.getAlfa());
			child1.setBetta(xromocomaParent2.getBetta());
			child1.setGamma(xromocomaParent1.getGamma());
			child2.setAlfa(xromocomaParent2.getAlfa());
			child2.setBetta(xromocomaParent1.getBetta());
			child2.setGamma(xromocomaParent2.getGamma());
			childrenListAfterCrossover.add(child1);
			childrenListAfterCrossover.add(child2);
			System.out.println(
					" Родитель1 :" + xromocomaParent1 + "\n" + " Родитель2 :" + xromocomaParent2 + "\n" + "  Потомок1 :" + child1 + "\n"
							+ "  Потомок2 :" + child2 + "\n");
		}
		return childrenListAfterCrossover;
	}

	/**
	 * Возвращает одного потомка
	 */
	public static ArrayList<Xromocoma> getChidrenPairsFlatCrossover(ArrayList<ArrayList<Xromocoma>> pairsForSelections) {
		childrenListAfterCrossover.clear();
		System.out.println("Результат Flat Crossover(FC)");
		Xromocoma child1;
		Xromocoma xromocomaParent1;
		Xromocoma xromocomaParent2;
		for (int i = 0; i < pairsForSelections.size(); i++) {
			child1 = new Xromocoma();
			xromocomaParent1 = pairsForSelections.get(i).get(0);
			xromocomaParent2 = pairsForSelections.get(i).get(1);
			for (int j = 0; j < QUANTITYOfGen; j++) {
				child1.setAlfa(formatChildFlatParameter(xromocomaParent1.getAlfa(), xromocomaParent2.getAlfa()));
				child1.setBetta(formatChildFlatParameter(xromocomaParent1.getBetta(), xromocomaParent2.getBetta()));
				child1.setGamma(formatChildFlatParameter(xromocomaParent1.getGamma(), xromocomaParent2.getGamma()));
			}
			childrenListAfterCrossover.add(child1);
			System.out.println(
					" Родитель1 :" + xromocomaParent1 + "\n" + " Родитель2 :" + xromocomaParent2 + "\n" + "  Потомок1 :" + child1 + "\n");
		}
		return childrenListAfterCrossover;
	}

	static double formatChildFlatParameter(double x1, double x2) {
		double temp = 0.0;
		Random random = new Random();
		if (x1 > x2) {
			temp = x2 + new Random().nextDouble() * (x1 - x2);
		} else {
			temp = x1 + new Random().nextDouble() * (x2 - x1);
		}
		//System.out.println("x1  "+x1 + "  x2 " + x2 + "  x3 " + alfa);
		return temp;
	}

	/**
	 * Возвращает два потомка
	 */
	public static ArrayList<Xromocoma> getChidrenPairsArithmaticalCrossover(ArrayList<ArrayList<Xromocoma>> pairsForSelections) {
		childrenListAfterCrossover.clear();
		System.out.println("Результат Arithmatical Crossover(AC)");
		Xromocoma child1;
		Xromocoma child2;
		Xromocoma xromocomaParent1;
		Xromocoma xromocomaParent2;
		for (int i = 0; i < pairsForSelections.size(); i++) {
			child1 = new Xromocoma();
			child2 = new Xromocoma();
			xromocomaParent1 = pairsForSelections.get(i).get(0);
			xromocomaParent2 = pairsForSelections.get(i).get(1);
			ArrayList<Xromocoma> result = formatChildFlatParameter(xromocomaParent1, xromocomaParent2);
			child1 = result.get(0);
			child2 = result.get(1);
			childrenListAfterCrossover.add(child1);
			childrenListAfterCrossover.add(child2);
			System.out.println(
					" Родитель1 :" + xromocomaParent1 + "\n" + " Родитель2 :" + xromocomaParent2 + "\n" + "  Потомок1 :" + child1 + "\n"
							+ "  Потомок2 :" + child2 + "\n");
		}
		return childrenListAfterCrossover;
	}

	static ArrayList<Xromocoma> formatChildFlatParameter(Xromocoma x1, Xromocoma x2) {
		ArrayList<Xromocoma> list = new ArrayList<>();
		Random random = new Random();
		double n = random.nextDouble();
		double alfaX1 = (n * x1.getAlfa() + (1 - n) * x2.getAlfa());
		double bettaX1 = (n * x1.getBetta() + (1 - n) * x2.getBetta());
		double gammaX1 = (n * x1.getGamma() + (1 - n) * x2.getGamma());
		list.add(new Xromocoma(alfaX1, bettaX1, gammaX1));
		double alfaX2 = (n * x2.getAlfa() + (1 - n) * x1.getAlfa());
		double bettaX2 = (n * x2.getBetta() + (1 - n) * x1.getBetta());
		double gammaX2 = (n * x2.getGamma() + (1 - n) * x1.getGamma());
		list.add(new Xromocoma(alfaX2, bettaX2, gammaX2));
		return list;
	}

	/**
	 * Возвращает одного потомка
	 */
	public static ArrayList<Xromocoma> getChidrenPairsDiscreteCrossover(ArrayList<ArrayList<Xromocoma>> pairsForSelections) {
		childrenListAfterCrossover.clear();
		System.out.println("Результат Discrete Crossover(DC)");
		Xromocoma child1;
		Xromocoma xromocomaParent1;
		Xromocoma xromocomaParent2;
		for (int i = 0; i < pairsForSelections.size(); i++) {
			child1 = new Xromocoma();
			xromocomaParent1 = pairsForSelections.get(i).get(0);
			xromocomaParent2 = pairsForSelections.get(i).get(1);
			for (int j = 0; j < QUANTITYOfGen; j++) {
				child1.setAlfa(formatChildDiscreteParameter(xromocomaParent1.getAlfa(), xromocomaParent2.getAlfa()));
				child1.setBetta(formatChildDiscreteParameter(xromocomaParent1.getBetta(), xromocomaParent2.getBetta()));
				child1.setGamma(formatChildDiscreteParameter(xromocomaParent1.getGamma(), xromocomaParent2.getGamma()));
			}
			childrenListAfterCrossover.add(child1);
			System.out.println(
					" Родитель1 :" + xromocomaParent1 + "\n" + " Родитель2 :" + xromocomaParent2 + "\n" + "  Потомок1 :" + child1 + "\n");
		}
		return childrenListAfterCrossover;
	}

	static double formatChildDiscreteParameter(double x1, double x2) {
		return Math.random() < 0.5 ? x1 : x2;
	}
}
