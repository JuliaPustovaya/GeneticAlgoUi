/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import sample.version16_10_din_ryad.*;

import static sample.Controller.IdClickedAnalysisBtn;

/**
 * @author Юлия
 */
public class FXMLDocumentController implements Initializable {

    // DynamicSeria ds = new DynamicSeria();
    @FXML
    private ListView lv1;
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
    }

    @FXML
    private TableView<Zgladgyvanya> tableZgladgyvanya;
    @FXML
    TableColumn<Zgladgyvanya, Integer> idColumn;
    @FXML
    private TableColumn<Zgladgyvanya, Double> initialValueColumn;
    @FXML
    private TableColumn<Zgladgyvanya, Double> mnkColumn;
    @FXML
    private TableColumn<Zgladgyvanya, Double> vidhilenyaMNK;
    @FXML
    private TableColumn<Zgladgyvanya, Double> medColumn;
    @FXML
    private TableColumn<Zgladgyvanya, Double> vidhilenyaMED;

    @Override
    public void initialize(URL url, ResourceBundle rb) {



        DynamicSeria ds = new DynamicSeria();
        if(IdClickedAnalysisBtn.equals("btnOpenNewWindow")) {
            ReadPoints.readDataInListFromTimeseria(ds, Controller.readedTimeSeriaFromFile);
        }
        else if(IdClickedAnalysisBtn.equals("btnOpenNewWindowK")){
            ReadPoints.readDataInListFromKData(ds, SA.GA.RunAll.datafromfile);
        }
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
        dch.drawChart(chart1, ds.getDynamic_seria(), "Вихідний динамічний ряд");
        dch.drawGistogramma(gistogramma, kr.getListofcorr(), "Корелограмма");
        dch.drawDS_Sglaginie(chart2, ds.getDynamic_seria(), ms.getListofmedians(), "Медіанне згладжування ");
        DynamicSeria d = new DynamicSeria();
        dch.drawDS_Sglaginie(chart3, ds.getDynamic_seria(), d.fillSeriawithdouble(mnk.getResult()), "МНК згладжування");
        ReflactionData rf = new ReflactionData();
        rf.reflactHipoteza(mz, sp, lv1);
        idColumn.setCellValueFactory(new PropertyValueFactory<Zgladgyvanya, Integer>("id"));
        initialValueColumn.setCellValueFactory(new PropertyValueFactory<Zgladgyvanya, Double>("initialValue"));
        mnkColumn.setCellValueFactory(new PropertyValueFactory<Zgladgyvanya, Double>("mnk"));
        vidhilenyaMNK.setCellValueFactory(new PropertyValueFactory<Zgladgyvanya, Double>("vidhilenyaMNK"));
        medColumn.setCellValueFactory(new PropertyValueFactory<Zgladgyvanya, Double>("med"));
        vidhilenyaMED.setCellValueFactory(new PropertyValueFactory<Zgladgyvanya, Double>("vidhilenyaMED"));
        tableZgladgyvanya.setItems(rf.reflactIntoTabe(ds.getDynamic_seria(), d.fillSeriawithdouble(mnk.getResult()), ms.getListofmedians()));
        rf.reflact(ds.getDynamic_seria(),  d.fillSeriawithdouble(mnk.getResult()), ms.getListofmedians(), lv1);
    }

}
