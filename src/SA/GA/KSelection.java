package SA.GA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class KSelection {
    public static ArrayList<ArrayList<KXromocoma>> parentsPairsForSelections = new ArrayList<>();

    public  static ArrayList<ArrayList<KXromocoma>> getParentsPairsForSelections(ArrayList<KXromocoma> selectedXromocoms) {
        parentsPairsForSelections.clear();
        for (int i = 0; i < selectedXromocoms.size(); i++) {
            Random random = new Random();
            int numberParent1 = random.nextInt(selectedXromocoms.size());
            int numberParent2 = random.nextInt(selectedXromocoms.size());
            parentsPairsForSelections.add(new ArrayList(Arrays.asList(selectedXromocoms.get(numberParent1), selectedXromocoms.get(numberParent2))));
            System.out.println("Пары родителей для скрещивания  " + parentsPairsForSelections.get(i));
       }

        return parentsPairsForSelections;
    }
}
