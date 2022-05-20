package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
 
    	updateDiagram();
    	
    	model.winesList.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				updateDiagram();
				
			}
		});
    	
    	
    	

    }

	private void updateDiagram() {
		
		System.out.println("******************* UPDATE Variety Diagram *************************************");
		
		List<Variety> listVarieties = model.winesList.stream()
				.map(w -> w.getVariety())
				.collect(Collectors.toList());

		System.out.println(listVarieties);


		Set<Variety> varietiesSet = new HashSet<>(listVarieties);

		ObservableList<PieChart.Data> varietyPieChartData = FXCollections.observableArrayList();

		PieChart.Data varietyData = null;


			for (Variety variety : varietiesSet) {

					varietyData = new PieChart.Data(variety.getName(), 
								Double.valueOf(Collections.frequency(listVarieties, variety)));
					varietyPieChartData.add(varietyData);

			}


			varietyPieChart.setData(varietyPieChartData);
			varietyPieChart.setTitle("Weinbestand nach Rebsorten");
			varietyPieChart.setClockwise(true);
			varietyPieChart.setLegendVisible(true);	
		
		
	}

}
