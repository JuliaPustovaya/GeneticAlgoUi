package GA;

import static GA.Crossover.childrenListAfterCrossover;
import static GA.Mutation.childrenAfterMutation;
import static GA.NewPopulation.selectedXromocomaInNewPopulation;
import static GA.Population.selectedParentsForSelection;
import static GA.Selection.parentsPairsForSelections;

public class CleanStaticVariables {
	public static void cleanStaticVariables() {
		parentsPairsForSelections.clear();
		selectedXromocomaInNewPopulation.clear();
		childrenAfterMutation.clear();
		selectedParentsForSelection.clear();
		childrenListAfterCrossover.clear();
	}
}
