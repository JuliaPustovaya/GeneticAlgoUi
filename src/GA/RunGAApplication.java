package GA;

import static GA.Crossover.childrenListAfterCrossover;

public class RunGAApplication {

	public static double getFitness(double alfa, double beta, double gama) {
		return Math.random();
	}

	public static void main(String[] args) throws Exception {
		Population.makeRandomPopulation();
		//TODO кол-во итераций отбора детей
		for (int i = 0; i < 20; i++) {
			CleanStaticVariables.cleanStaticVariables();
			Population.makeRuletSelection();
			Selection.getParentsPairsForSelections(Population.selectedParentsForSelection);
			//		Crossover.getChidrenPairsTwoPointCrossover(Selection.parentsPairsForSelections);
			//		Crossover.getChidrenPairsFlatCrossover(Selection.parentsPairsForSelections);
			//    	Crossover.getChidrenPairsArithmaticalCrossover(Selection.parentsPairsForSelections);
			Crossover.getChidrenPairsDiscreteCrossover(Selection.parentsPairsForSelections);
			Mutation.RandomMutation(childrenListAfterCrossover);
			NewPopulation.selectXromocomaInNewPopulation(NewPopulation.formNewPopulation(Population.populationXromocoma, Mutation.childrenAfterMutation));

		}
	}
}
