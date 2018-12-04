package SA.GA;

import static SA.GA.KCrossover.childrenListAfterCrossover;

public class KRunGAApplication {
//public static  double getFitness(double al,double bl){
//	return Math.random();
//}

	public static void main(String[] args) throws Exception {
		KPopulation.makeRandomPopulation();
		//TODO кол-во итераций отбора детей
		for (int i = 0; i < 1; i++) {

			KPopulation.makeRuletSelection();
			KSelection.getParentsPairsForSelections(KPopulation.selectedParentsForSelection);
			//		Crossover.getChidrenPairsTwoPointCrossover(Selection.parentsPairsForSelections);
			//		Crossover.getChidrenPairsFlatCrossover(Selection.parentsPairsForSelections);
			//    	Crossover.getChidrenPairsArithmaticalCrossover(Selection.parentsPairsForSelections);
			KCrossover.getChidrenPairsDiscreteCrossover(KSelection.parentsPairsForSelections);
			KMutation.RandomMutation(childrenListAfterCrossover);
			KNewPopulation.selectXromocomaInNewPopulation(KNewPopulation.formNewPopulation(KPopulation.populationXromocoma, KMutation.childrenAfterMutation));

		}
	}
}
