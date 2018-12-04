package SA.GA;

import java.util.ArrayList;
import java.util.Random;

import static SA.GA.KGAparametrs.QUANTITYOfGen;

public class KCrossover {

    public static ArrayList<KXromocoma> childrenListAfterCrossover = new ArrayList<>();

    /**
     * Возвращает два потомка
     **/
    public static ArrayList<KXromocoma> getChidrenPairsTwoPointCrossover(ArrayList<ArrayList<KXromocoma>> pairsForSelections) {
        childrenListAfterCrossover.clear();
        System.out.println("Результат кроссовера Two-point Crossover ");
        KXromocoma child1;
        KXromocoma child2;
        for (int i = 0; i < pairsForSelections.size(); i++) {
            KXromocoma xromocomaParent1 = pairsForSelections.get(i).get(0);
            KXromocoma xromocomaParent2 = pairsForSelections.get(i).get(1);
            child1 = new KXromocoma();
            child2 = new KXromocoma();
            child1.setAlfa(xromocomaParent1.getAlfa());
            child1.setBetta(xromocomaParent2.getBetta());
            child2.setAlfa(xromocomaParent2.getAlfa());
            child2.setBetta(xromocomaParent1.getBetta());
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
    public static ArrayList<KXromocoma> getChidrenPairsFlatCrossover(ArrayList<ArrayList<KXromocoma>> pairsForSelections) {
        childrenListAfterCrossover.clear();
        System.out.println("Результат Flat Crossover(FC)");
        KXromocoma child1;
        KXromocoma xromocomaParent1;
        KXromocoma xromocomaParent2;
        for (int i = 0; i < pairsForSelections.size(); i++) {
            child1 = new KXromocoma();
            xromocomaParent1 = pairsForSelections.get(i).get(0);
            xromocomaParent2 = pairsForSelections.get(i).get(1);
            for (int j = 0; j < QUANTITYOfGen; j++) {
                child1.setAlfa(formatChildFlatParameter(xromocomaParent1.getAlfa(), xromocomaParent2.getAlfa()));
                child1.setBetta(formatChildFlatParameter(xromocomaParent1.getBetta(), xromocomaParent2.getBetta()));

            }
            childrenListAfterCrossover.add(child1);
            System.out.println(
                    " Родитель1 :" + xromocomaParent1 + "\n" + " Родитель2 :" + xromocomaParent2 + "\n" + "  Потомок1 :" + child1 + "\n");
        }
        return childrenListAfterCrossover;
    }

    static int formatChildFlatParameter(double x1, double x2) {
        double temp = 0.0;
        Random random = new Random();
        if (x1 > x2) {
            temp = x2 + new Random().nextDouble() * (x1 - x2);
        } else {
            temp = x1 + new Random().nextDouble() * (x2 - x1);
        }
        //System.out.println("x1  "+x1 + "  x2 " + x2 + "  x3 " + alfa);
        return (int) temp;
    }

    /**
     * Возвращает два потомка
     */
    public static ArrayList<KXromocoma> getChidrenPairsArithmaticalCrossover(ArrayList<ArrayList<KXromocoma>> pairsForSelections) {
        childrenListAfterCrossover.clear();
        System.out.println("Результат Arithmatical Crossover(AC)");
        KXromocoma child1;
        KXromocoma child2;
        KXromocoma xromocomaParent1;
        KXromocoma xromocomaParent2;
        for (int i = 0; i < pairsForSelections.size(); i++) {
            child1 = new KXromocoma();
            child2 = new KXromocoma();
            xromocomaParent1 = pairsForSelections.get(i).get(0);
            xromocomaParent2 = pairsForSelections.get(i).get(1);
            ArrayList<KXromocoma> result = formatChildFlatParameter(xromocomaParent1, xromocomaParent2);
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

    static ArrayList<KXromocoma> formatChildFlatParameter(KXromocoma x1, KXromocoma x2) {
        ArrayList<KXromocoma> list = new ArrayList<>();
        Random random = new Random();
        double n = random.nextDouble();
        double alfaX1 = (n * x1.getAlfa() + (1 - n) * x2.getAlfa());
        double bettaX1 = (n * x1.getBetta() + (1 - n) * x2.getBetta());
        double alfaX2 = (n * x2.getAlfa() + (1 - n) * x1.getAlfa());
        double bettaX2 = (n * x2.getBetta() + (1 - n) * x1.getBetta());
        return list;
    }

    /**
     * Возвращает одного потомка
     */
    public static ArrayList<KXromocoma> getChidrenPairsDiscreteCrossover(ArrayList<ArrayList<KXromocoma>> pairsForSelections) {
        childrenListAfterCrossover.clear();
        System.out.println("Результат Discrete Crossover(DC)");
        KXromocoma child1;
        KXromocoma xromocomaParent1;
        KXromocoma xromocomaParent2;
        for (int i = 0; i < pairsForSelections.size(); i++) {
            child1 = new KXromocoma();
            xromocomaParent1 = pairsForSelections.get(i).get(0);
            xromocomaParent2 = pairsForSelections.get(i).get(1);
            for (int j = 0; j < QUANTITYOfGen; j++) {
                child1.setAlfa(formatChildDiscreteParameter(xromocomaParent1.getAlfa(), xromocomaParent2.getAlfa()));
                child1.setBetta(formatChildDiscreteParameter(xromocomaParent1.getBetta(), xromocomaParent2.getBetta()));

            }
            childrenListAfterCrossover.add(child1);
            System.out.println(
                    " Родитель1 :" + xromocomaParent1 + "\n" + " Родитель2 :" + xromocomaParent2 + "\n" + "  Потомок1 :" + child1 + "\n");
        }
        return childrenListAfterCrossover;
    }

    static int formatChildDiscreteParameter(int x1, int x2) {
        return Math.random() < 0.5 ? x1 : x2;
    }
}
