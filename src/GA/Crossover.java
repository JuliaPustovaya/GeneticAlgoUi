package GA;

import java.util.ArrayList;

import static GA.GAparametrs.QUANTITYOfGen;

public class Crossover {
    public static ArrayList<Xromocoma> getChidrenPairsOnePointCrossover(ArrayList<ArrayList<Xromocoma>> pairsForSelections) {
        for (int i = 0; i < pairsForSelections.size(); i++) {
            int index = QUANTITYOfGen / 2;
            Xromocoma xromocomaParent1 = pairsForSelections.get(i).get(0);
            Xromocoma xromocomaParent2 = pairsForSelections.get(i).get(1);
            for (int j = 0; j < index; j++) {
                //TODO !  значения генов хромосомы записать в масссив/ список и в ребенка добавлить части списка родителей-хромосом
            }
        }
        return new ArrayList<>();
    }
}
