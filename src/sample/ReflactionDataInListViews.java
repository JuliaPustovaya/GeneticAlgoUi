package sample;

import Exp3.TimeSeria;
import GA.Xromocoma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ReflactionDataInListViews {
    public static void reflactDataIntoLists(ListView view, ArrayList<Double> list1, ArrayList<Double> list2) {
        view.getItems().clear();
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("№    Реальне     Прогнозне");
        for (int i = 0; i < list1.size(); i++) {
            list.add(i+1+ "     "+new DecimalFormat("#0.000").format(list1.get(i)) + "      " + new DecimalFormat("#0.000").format(list2.get(i)));
        }
        view.setItems(list);

    }

    public static void reflactDataIntoListView(ListView view, ArrayList<TimeSeria> list1) {
        view.getItems().clear();
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add(" №          Значення");
        for (int i = 0; i < list1.size(); i++) {
            list.add(i+1 + "           " + new DecimalFormat("#0.000").format(list1.get(i).getYt()));
        }
        view.setItems(list);

    }
}
