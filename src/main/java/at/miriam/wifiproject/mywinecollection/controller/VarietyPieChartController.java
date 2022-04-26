package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.util.ResourceBundle;

import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class VarietyPieChartController extends BaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private PieChart varietyPieChart;

    @FXML
    void initialize() {
    	assert varietyPieChart != null : "fx:id=\"varietyPieChart\" was not injected: check your FXML file 'VarietyPieChartView.fxml'.";
 
    	
    	ObservableList<PieChart.Data> varietyPieChartData = FXCollections.observableArrayList(
    			new PieChart.Data("Grüner Veltliner", 20),
    			new PieChart.Data("Riesling", 15),
    			new PieChart.Data("Zweigelt", 8),
    			new PieChart.Data("Cuvée", 14),
    			new PieChart.Data("Pinot noir", 10));
    	
  
    	varietyPieChart.setData(varietyPieChartData);
    	varietyPieChart.setTitle("Weinbestand nach Rebsorten");
    	varietyPieChart.setClockwise(true);
    	varietyPieChart.setLegendVisible(false);
    	

    }

}
