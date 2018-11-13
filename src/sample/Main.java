package sample;

import Exp3.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import static Exp3.Coefficients.*;
import static Exp3.Forecasting.printForecastedValues;
import static Exp3.HoltWintersTripleExponentialImpl.getHW;
import static Exp3.UpdatedTimeSeria.getUpdatedTimeSeria;
import static jdk.nashorn.internal.objects.NativeArray.forEach;

public class Main extends Application {
    public static ArrayList<TimeSeria> timeSeria = new ArrayList<TimeSeria>();
    public static ArrayList<UpdatedTimeSeria> updatedTimeSerias = new ArrayList<UpdatedTimeSeria>();
    public static ArrayList<Double> realResult = new ArrayList<>();
    public static ArrayList<Double> forecastResult = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        ReadFromFile.openFile(timeSeria, realResult);
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
        WriteToFile.writeToFile(updatedTimeSerias, "Updated St, Bt, Ct");
        Forecasting forecasting = new Forecasting();
        forecasting.getForecastedValues(updatedTimeSerias, 12);
        printForecastedValues(forecastResult);
        WriteToFile.writeToFile(forecastResult, "Forecasted values : ");
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Integer, Double> linechart = new LineChart(xAxis, yAxis);
        linechart.setPrefHeight(500);
        linechart.setPrefWidth(600);
        XYChart.Series timeseria = new XYChart.Series();
        XYChart.Series forecasted = new XYChart.Series();
        XYChart.Series secondforecasted = new XYChart.Series();
        timeseria.setName("No of schools in an year");
        for (int i = 0; i < timeSeria.size(); i++) {
            timeseria.getData().add(new XYChart.Data(i, timeSeria.get(i).getYt()));
        }
        int startIndex = timeseria.getData().size() - 1;
        for (int i = 0; i < forecastResult.size(); i++) {
            forecasted.getData().add(new XYChart.Data(startIndex + i, forecastResult.get(i)));
        }
        ArrayList<Double> second = getHW();
        for (int i = 0; i < second.size(); i++) {
            secondforecasted.getData().add(new XYChart.Data(startIndex + i, second.get(i)));
        }
        timeseria.setName("No of schools in an year");
        //Setting the data to Line chart
        linechart.getData().add(timeseria);
        linechart.getData().add(forecasted);
        //   linechart.getData().add(secondforecasted);
        //Creating a Group object
        Group root = new Group(linechart);
        //Creating a scene object
        Scene scene = new Scene(root, 800, 600);
        //Setting title to the Stage
        stage.setTitle("Line Chart");
        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();

    }

    public static void main(String args[]) {
        launch(args);
    }

}
