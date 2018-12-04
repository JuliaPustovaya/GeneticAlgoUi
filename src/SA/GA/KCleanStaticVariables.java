package SA.GA;

import static SA.GA.KCrossover.childrenListAfterCrossover;
import static SA.GA.KMutation.childrenAfterMutation;
import static SA.GA.KNewPopulation.selectedXromocomaInNewPopulation;
import static SA.GA.KPopulation.populationXromocoma;
import static SA.GA.KPopulation.selectedParentsForSelection;
import static SA.GA.KSelection.parentsPairsForSelections;

public class KCleanStaticVariables {
	public static void cleanStaticVariables() {
		populationXromocoma.clear();
		parentsPairsForSelections.clear();
		selectedXromocomaInNewPopulation.clear();
		childrenAfterMutation.clear();
		selectedParentsForSelection.clear();
		childrenListAfterCrossover.clear();
	}
}
