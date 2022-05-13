package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
 
    	System.out.println("Variety PieChart initialize");
    	
    
    
    	List<Wine> listVarieties = model.winesList.stream()
    												.filter(w -> w.getVariety().getName() != null)
    												//.distinct()
    												.collect(Collectors.toList());
    	
    	System.out.println(listVarieties);
    	
    	
    	
    	ObservableList<PieChart.Data> varietyPieChartData = FXCollections.observableArrayList();
    	
    	PieChart.Data varietyData = null;
    
    	for (int i=0; i < listVarieties.size(); i++) {
    		
    		varietyData = new PieChart.Data(listVarieties.get(i).toString(), Double.valueOf(i));
    		varietyPieChartData.add(varietyData);
    	}
    
    	
    	
    	
  
    	varietyPieChart.setData(varietyPieChartData);
    	varietyPieChart.setTitle("Weinbestand nach Rebsorten");
    	varietyPieChart.setClockwise(true);
    	varietyPieChart.setLegendVisible(false);
    	

    }

}
