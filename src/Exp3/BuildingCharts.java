
package Exp3;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;

import static SA.GA.KGAparametrs.amountForecasting;

public class BuildingCharts {
    public static void buildChart(LineChart linechart, ArrayList<TimeSeria> timeSeriaElements, ArrayList realElements, ArrayList forecastedElements) {
        linechart.getData().clear();
        XYChart.Series seriaRealElemets = new XYChart.Series();
        XYChart.Series seriaForecastedElemnts = new XYChart.Series();
        ArrayList<Double> temp = new ArrayList<>();
        for (int i = 0; i < timeSeriaElements.size(); i++) {
            temp.add(timeSeriaElements.get(i).getYt());
        }
        temp.addAll(realElements);
        for (int i = 0; i < temp.size(); i++) {
            seriaRealElemets.getData().add(new XYChart.Data(i, temp.get(i)));
        }
        int startIndex = timeSeriaElements.size();
        for (int i = 0; i < forecastedElements.size(); i++) {
            seriaForecastedElemnts.getData().add(new XYChart.Data(startIndex + i, forecastedElements.get(i)));
        }
        linechart.getData().add(seriaForecastedElemnts);
        linechart.getData().add(seriaRealElemets);
        seriaForecastedElemnts.setName("Прогнозні значення");
        seriaRealElemets.setName("Вихідні дані");
    }

    public static void buildChart(LineChart linechart, ArrayList<TimeSeria> timeSeriaElements) {
        linechart.getData().clear();
        XYChart.Series seriaTimeSeria = new XYChart.Series();
        for (int i = 0; i < timeSeriaElements.size(); i++) {
            seriaTimeSeria.getData().add(new XYChart.Data(i, timeSeriaElements.get(i).getYt()));
        }
        linechart.getData().add(seriaTimeSeria);
        seriaTimeSeria.setName("Исходный временной ряд");

    }
    public static void buildChartDouble(LineChart linechart, ArrayList<Double> list) {
        linechart.getData().clear();
        XYChart.Series seriaTimeSeria = new XYChart.Series();
        for (int i = 0; i < list.size(); i++) {
            seriaTimeSeria.getData().add(new XYChart.Data(i, list.get(i)));
        }
        linechart.getData().add(seriaTimeSeria);
        seriaTimeSeria.setName("Исходный временной ряд");

    }
    public static void buildChartDouble(LineChart linechart, ArrayList<Double> timeSeriaElements, ArrayList forecastedElements) {
        linechart.getData().clear();
        XYChart.Series seriaRealElemets = new XYChart.Series();
        XYChart.Series seriaForecastedElemnts = new XYChart.Series();

        for (int i = 0; i < timeSeriaElements.size()-amountForecasting; i++) {

            seriaRealElemets.getData().add(new XYChart.Data(i, timeSeriaElements.get(i)));
        }


        for (int i = timeSeriaElements.size()-amountForecasting; i < forecastedElements.size(); i++) {
            seriaForecastedElemnts.getData().add(new XYChart.Data( i, forecastedElements.get(i)));
        }
        linechart.getData().add(seriaForecastedElemnts);
        linechart.getData().add(seriaRealElemets);
        seriaForecastedElemnts.setName("Прогнозні значення");
        seriaRealElemets.setName("Вихідні дані");
    }
}




