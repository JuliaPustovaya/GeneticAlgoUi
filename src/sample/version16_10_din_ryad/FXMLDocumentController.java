/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.version16_10_din_ryad;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author Юлия
 */
public class FXMLDocumentController implements Initializable {

    // DynamicSeria ds = new DynamicSeria();
    @FXML
    private ListView lv1,lv2;
    @FXML
    private Label label;
    @FXML
    private ScatterChart chart1, chart2, chart3;
    @FXML
    public BarChart gistogramma;

    @FXML
    public NumberAxis x1, y1, gistogrammaX, gistogrammaY, x2, x3, y3;

    @FXML
    public AnchorPane Content;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        DynamicSeria ds = new DynamicSeria();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("All Files", "*.*"));
        fileChooser.setTitle("Open Document");
        File file = fileChooser.showOpenDialog(null);

        ReadPoints.readDataInArray(ds, file.getAbsolutePath());
        MethodZnakov mz = new MethodZnakov();
        mz.setExtriPpoints(ds.getDynamic_seria());
        mz.getExtrimSum(mz.getExtriPpoints());
        mz.reckonD(ds);
        mz.reckonM(ds);
        mz.reckonS();
        mz.toString();
        mz.setHipoteza();
        Spirman sp = new Spirman(ds.getQuantity());
        sp.reckonMatrix_indicator(ds);
        sp.reckonV_statistika(sp.getMatrix_indicator());
        sp.reckonKoefrangkorel(ds.getQuantity());
        sp.rekonS_statiska(ds.getQuantity());
        sp.setHipoteza();
        Korelogramma kr = new Korelogramma();
        kr.transformDSX(ds.getDynamic_seria());
        kr.transformDSY(ds.getDynamic_seria());
        kr.formArrayCorr(ds.getDynamic_seria());
        MediannoeSglagivanie ms = new MediannoeSglagivanie();
        ms.formListdsForMedians(ds.getDynamic_seria(), 9);
        ms.rankListofMedians(ds.getDynamic_seria());
        MNK mnk = new MNK();
        mnk.formList_okon(ds.getDynamic_seria(), 9);
        mnk.rank_U_(4);

        DrawCharts dch = new DrawCharts();
        dch.drawChart(chart1, ds.getDynamic_seria(), "Исходный Динамический ряд");
        dch.drawGistogramma(gistogramma, kr.getListofcorr(), "Кореллограмма");
        dch.drawDS_Sglaginie(chart2, ds.getDynamic_seria(), ms.getListofmedians(), "Медианное сглаживание");
        DynamicSeria d = new DynamicSeria();
        dch.drawDS_Sglaginie(chart3, ds.getDynamic_seria(), d.fillSeriawithdouble(mnk.getResult()), "МНК сглаживание");
 
        ReflactionData rf= new ReflactionData();
        rf.reflactHipoteza(mz, sp, lv1);
        rf.reflact(ds.getDynamic_seria(),  d.fillSeriawithdouble(mnk.getResult()), ms.getListofmedians(), lv2);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
