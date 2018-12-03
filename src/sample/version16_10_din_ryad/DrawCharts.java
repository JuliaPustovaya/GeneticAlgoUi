/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.version16_10_din_ryad;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

/**
 * @author Юлия
 */
public class DrawCharts {

    public void drawChart(XYChart kBubbleChart, ArrayList<Points> ps, String st) {
        kBubbleChart.setTitle(st);
        XYChart.Series series1 = new XYChart.Series();
        for (int i = 0; i < ps.size(); i++) {
            series1.getData().add(new XYChart.Data(ps.get(i).getPoint(), i));

        }
        ArrayList<XYChart.Series<Double, Double>> serias = new ArrayList<>();
        serias.add(series1);
        ObservableList general = FXCollections.observableArrayList();
        general.addAll(serias);
        kBubbleChart.setData(general);

    }

    public void drawGistogramma(XYChart kBubbleChart, ArrayList<Double> ps, String st) {
        kBubbleChart.setTitle(st);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("r");
        for (int i = 0; i < ps.size(); i++) {
            series1.getData().add(new XYChart.Data("" + i, ps.get(i)));

        }
        ArrayList<XYChart.Series<Double, Double>> serias = new ArrayList<>();
        serias.add(series1);
        ObservableList general = FXCollections.observableArrayList();
        general.addAll(serias);
        kBubbleChart.setData(general);

    }

    public void drawDS_Sglaginie(XYChart kBubbleChart, ArrayList<Points> ps, ArrayList<Points> update, String st) {
        kBubbleChart.setTitle(st);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Вихідний ряд");
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Згладженний ряд");
        for (int i = 0; i < ps.size(); i++) {
            series1.getData().add(new XYChart.Data(ps.get(i).getPoint(), i));
            series2.getData().add(new XYChart.Data(update.get(i).getPoint(), i));
        }
        ArrayList<XYChart.Series<Double, Double>> serias = new ArrayList<>();
        serias.add(series1);
        serias.add(series2);
        ObservableList general = FXCollections.observableArrayList();
        general.addAll(serias);
        kBubbleChart.setData(general);

    }

}
