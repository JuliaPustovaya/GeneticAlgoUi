/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.version16_10_din_ryad;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import javax.swing.text.TableView;

/**
 * @author Юлия
 */
public class ReflactionData {

    public void reflactHipoteza(MethodZnakov mz, Spirman sp, ListView lv) {
        ObservableList tm = FXCollections.observableArrayList();
        tm.clear();
        tm.add(0, "МЕТОД ЗНАКІВ ");
        tm.add(1, "S = " + new DecimalFormat("#0.000").format(mz.getS()));
        //  tm.add(2, "Kвантиль = " + new DecimalFormat("#0.000").format(Kvantili.kvantil_norm_raspred()));
        tm.add(2, "Гіпотеза = " + mz.getHipoteza());
        tm.add(3, " МЕТОД СПІРМЕНА ");
        tm.add(4, "S = " + new DecimalFormat("#0.000").format(sp.getS_statistica()));
        tm.add(5, "Гіпотеза = " + sp.getHipoteza());
        lv.setItems(tm);

    }

    public void reflact(ArrayList<Points> original, ArrayList<Points> mnk, ArrayList<Points> med, ListView lv) {

        double srednya_poh_mnk = 0.0;
        double srednya_poh_med = 0.0;
        double sum = 0.0;
        double sum1 = 0.0;
        for (int i = 0; i < original.size(); i++) {
            sum = sum + Math.pow(original.get(i).getPoint() - mnk.get(i).getPoint(), 2);
            sum1 = sum1 + Math.pow(original.get(i).getPoint() - med.get(i).getPoint(), 2);

        }
        srednya_poh_med = sum1 / (double) original.size();
        srednya_poh_mnk = sum / (double) original.size();
        ObservableList tm = FXCollections.observableArrayList();
        tm.clear();

        tm.add(" MSE (медіанне згладжування): " + new DecimalFormat("#0.000").format(srednya_poh_med));
        tm.add(" MSE (мнк згладжування) : " + new DecimalFormat("#0.000").format(srednya_poh_mnk));

        lv.getItems().add(tm.get(0));
        lv.getItems().add(tm.get(1));
    }

    public ObservableList<Zgladgyvanya> reflactIntoTabe(ArrayList<Points> original, ArrayList<Points> mnk, ArrayList<Points> med) {
        ArrayList<Double> vidhilenya_mnk = new ArrayList<>();
        ArrayList<Double> vidhilenya_med = new ArrayList<>();
        for (int i = 0; i < original.size(); i++) {
            vidhilenya_mnk.add(original.get(i).getPoint() - mnk.get(i).getPoint());
            vidhilenya_med.add(original.get(i).getPoint() - med.get(i).getPoint());
        }
        ObservableList<Zgladgyvanya> tm = FXCollections.observableArrayList();
        tm.clear();
        for (int i = 0; i < original.size(); i++) {
            tm.add(new Zgladgyvanya(i, original.get(i).getPoint(), mnk.get(i).getPoint(), vidhilenya_mnk.get(i), med.get(i).getPoint(), vidhilenya_med.get(i)));

        }
        return tm;
    }

}
