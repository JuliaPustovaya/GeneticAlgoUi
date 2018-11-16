
package Exp3;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class BuildingCharts {
    public static void buildChart(LineChart linechart, ArrayList<TimeSeria> timeSeriaElements, ArrayList realElements, ArrayList forecastedElements) {
        linechart.getData().clear();
        XYChart.Series seriaTimeSeria = new XYChart.Series();
        XYChart.Series seriaRealElemets = new XYChart.Series();
        XYChart.Series seriaForecastedElemnts = new XYChart.Series();
        for (int i = 0; i < timeSeriaElements.size(); i++) {
            seriaTimeSeria.getData().add(new XYChart.Data(i, timeSeriaElements.get(i).getYt()));
        }
        int j = 0;
        for (int i = timeSeriaElements.size(); i < timeSeriaElements.size() + realElements.size(); i++) {
            seriaRealElemets.getData().add(new XYChart.Data(i, realElements.get(j++)));
        }
        int startIndex = seriaTimeSeria.getData().size() - 1;
        for (int i = 0; i < forecastedElements.size(); i++) {
            seriaForecastedElemnts.getData().add(new XYChart.Data(startIndex + i, forecastedElements.get(i)));
        }
        linechart.getData().add(seriaTimeSeria);
        linechart.getData().add(seriaForecastedElemnts);
        linechart.getData().add(seriaRealElemets);
        seriaTimeSeria.setName("Исходный временной ряд");
        seriaForecastedElemnts.setName("Прогнозные значения");
        seriaRealElemets.setName("Исходные данные для сравнения результата прогноза ");
    }

}




