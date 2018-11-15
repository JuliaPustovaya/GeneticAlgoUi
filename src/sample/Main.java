package sample;

import Exp3.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

import static Exp3.Coefficients.*;
import static Exp3.Forecasting.printForecastedValues;
import static Exp3.UpdatedTimeSeria.getUpdatedTimeSeria;

public class Main extends Application {
    public static ArrayList<TimeSeria> timeSeria = new ArrayList<TimeSeria>();
    public static ArrayList<UpdatedTimeSeria> updatedTimeSerias = new ArrayList<UpdatedTimeSeria>();
    public static ArrayList<Double> realResult = new ArrayList<>();

    public static ArrayList<Double> forecastResult = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {

        XYChart.Series timeseria = new XYChart.Series();
        XYChart.Series forecasted = new XYChart.Series();
        XYChart.Series real = new XYChart.Series();
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Integer, Double> linechart = new LineChart(xAxis, yAxis);
        linechart.setPrefHeight(500);
        linechart.setPrefWidth(600);
        timeseria.setName("Исхдный временной ряд");
        forecasted.setName("Прогнозные данные");
        real.setName("Real");


        ReadFromFile.openFile(timeSeria, realResult);
        for (int i = 0; i < timeSeria.size(); i++) {
            timeseria.getData().add(new XYChart.Data(i, timeSeria.get(i).getYt()));
        }

        linechart.getData().add(timeseria);


       System.out.println("Alfa= " + ALFA + ", Betta=  " + BETTA + ", Gamma=  " + GAMMA + ", Season=  " + L);
        InitialIndexis initialIndexis = new InitialIndexis();
        initialIndexis.formS0();
        initialIndexis.formB0();
        initialIndexis.formC0();
        System.out.println("s0 " + initialIndexis.getS0() + "\n" + "b0 " + initialIndexis.getB0() + "\n" + "c0 " + initialIndexis.getC0());
        FormattedIndexis formattedIndexis = new FormattedIndexis();
        for (int i = 1; i <= timeSeria.size(); i++) {
            formattedIndexis.formSt(i);
        }
        getUpdatedTimeSeria();
        Forecasting forecasting = new Forecasting();
        forecasting.getForecastedValues(updatedTimeSerias, 24);
        printForecastedValues(forecastResult);

        int j=0;
        for (int i = timeSeria.size(); i < timeSeria.size()+realResult.size(); i++) {
            real.getData().add(new XYChart.Data(i, realResult.get(j++)));
        }
        int startIndex = timeseria.getData().size() - 1;
        for (int i = 0; i < forecastResult.size(); i++) {
            forecasted.getData().add(new XYChart.Data(startIndex + i, forecastResult.get(i)));
        }
    ErrorCoeficients.getMSE(realResult, forecastResult);
	ErrorCoeficients.getE(realResult, forecastResult);



        linechart.getData().add(forecasted);
        linechart.getData().add(real);
        Group root = new Group(linechart);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }

}
