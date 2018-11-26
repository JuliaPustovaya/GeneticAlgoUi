package GA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Selection {
    public static ArrayList<ArrayList<Xromocoma>> parentsPairsForSelections = new ArrayList<>();

    public  static ArrayList<ArrayList<Xromocoma>> getParentsPairsForSelections(ArrayList<Xromocoma> selectedXromocoms) {
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
