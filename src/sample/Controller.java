package sample;

import Exp3.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Exp3.Coefficients.*;
import static Exp3.Forecasting.printForecastedValues;
import static Exp3.UpdatedTimeSeria.getUpdatedTimeSeria;

public class Controller implements Initializable {
    XYChart.Series timeseria = new XYChart.Series();
    XYChart.Series forecasted = new XYChart.Series();
    XYChart.Series real = new XYChart.Series();
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
        timeseria.getData().clear();
        real.getData().clear();
        forecasted.getData().clear();
        L = Integer.parseInt(textFieldL.getText());
        try {
            ReadFromFile.readDataFromFile(globalFilePath, timeSeria, realResult);
        } catch (Exception ex) {
        }
        lineChart.getData().clear();
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
        int j = 0;
        for (int i = timeSeria.size(); i < timeSeria.size() + realResult.size(); i++) {
            real.getData().add(new XYChart.Data(i, realResult.get(j++)));
        }
        int startIndex = timeseria.getData().size() - 1;
        for (int i = 0; i < forecastResult.size(); i++) {
            forecasted.getData().add(new XYChart.Data(startIndex + i, forecastResult.get(i)));
        }
        ErrorCoeficients.getMSE(realResult, forecastResult);
        ErrorCoeficients.getE(realResult, forecastResult);
        lineChart.getData().add(forecasted);
        lineChart.getData().add(real);

    }

    public static ArrayList<TimeSeria> timeSeria = new ArrayList<TimeSeria>();
    public static ArrayList<UpdatedTimeSeria> updatedTimeSerias = new ArrayList<UpdatedTimeSeria>();
    public static ArrayList<Double> realResult = new ArrayList<>();

    public static ArrayList<Double> forecastResult = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeseria.setName("Исхдный временной ряд");
        forecasted.setName("Прогнозные данные");
        real.setName("Real");

        try {
            ReadFromFile.openFile(timeSeria, realResult);
        } catch (Exception ex) {
        }
        for (int i = 0; i < timeSeria.size(); i++) {
            timeseria.getData().add(new XYChart.Data(i, timeSeria.get(i).getYt()));
        }
        lineChart.getData().add(timeseria);



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
        int j = 0;
        for (int i = timeSeria.size(); i < timeSeria.size() + realResult.size(); i++) {
            real.getData().add(new XYChart.Data(i, realResult.get(j++)));
        }
        int startIndex = timeseria.getData().size() - 1;
        for (int i = 0; i < forecastResult.size(); i++) {
            forecasted.getData().add(new XYChart.Data(startIndex + i, forecastResult.get(i)));
        }
        ErrorCoeficients.getMSE(realResult, forecastResult);
        ErrorCoeficients.getE(realResult, forecastResult);
        lineChart.getData().add(forecasted);
        lineChart.getData().add(real);
    }
}
