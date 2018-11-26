package sample;

import Exp3.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Exp3.Coefficients.*;
import static Exp3.Forecasting.printForecastedValues;
import static Exp3.UpdatedTimeSeria.getUpdatedTimeSeria;

public class Controller_1 implements Initializable {

    public static String globalFilePath;

    @FXML
    public LineChart lineChart;
    @FXML
    public Button forecast;
    @FXML
    public TextField textFieldL;
    @FXML
    public NumberAxis xAxis, yAxis;
    @FXML
    public Label Reflaction;

    @FXML
    public void getForecast(ActionEvent ev) {
        updatedTimeSerias.clear();
        forecastResult.clear();
        L = Integer.parseInt(textFieldL.getText());
        try {
            ReadFromFile.readDataFromFile(globalFilePath, timeSeria, realResult);
        } catch (Exception ex) {
        }
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
        ErrorCoeficients.getMSE(realResult, forecastResult);
        ErrorCoeficients.getE(realResult, forecastResult);
        BuildingCharts.buildChart(lineChart, timeSeria, realResult, forecastResult);

    }

    public static ArrayList<TimeSeria> timeSeria = new ArrayList<TimeSeria>();
    public static ArrayList<UpdatedTimeSeria> updatedTimeSerias = new ArrayList<UpdatedTimeSeria>();
    public static ArrayList<Double> realResult = new ArrayList<>();

    public static ArrayList<Double> forecastResult = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ReadFromFile.openFile(timeSeria, realResult);
        } catch (Exception ex) {
        }
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
        ErrorCoeficients.getMSE(realResult, forecastResult);
        ErrorCoeficients.getE(realResult, forecastResult);
        BuildingCharts.buildChart(lineChart, timeSeria, realResult, forecastResult);

    }



}
