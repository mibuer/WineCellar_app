package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import at.miriam.wifiproject.mywinecollection.model.Wine;
import at.miriam.wifiproject.mywinecollection.model.WineCategory;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class CategoryPieChartController extends BaseController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private PieChart categoryPieChart;

	@FXML
	void initialize() {
		assert categoryPieChart != null
				: "fx:id=\"categoryPieChart\" was not injected: check your FXML file 'CategoryPieChartView.fxml'.";

		updateDiagram();
		
		
		model.winesList.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				System.err.println("Update diagram");
				updateDiagram();
				
			}

			
		});
		
		
		
	}	

	private void updateDiagram() {
		
		List<WineCategory> listCategories = model.winesList.stream()
													.map(w -> w.getWineCategory())
													.collect(Collectors.toList());

		System.out.println(listCategories);

		Set<WineCategory> categoriesSet = new HashSet<>(listCategories);

		ObservableList<PieChart.Data> categoryPieChartData = FXCollections.observableArrayList();

		PieChart.Data categoryData = null;

			for (WineCategory category : categoriesSet) {

					categoryData = new PieChart.Data(category.getCode(),
						Double.valueOf(Collections.frequency(listCategories, category)));
						categoryPieChartData.add(categoryData);
			}

			categoryPieChart.setData(categoryPieChartData);
			categoryPieChart.setTitle("Weinbestand nach Kategorien");
			categoryPieChart.setClockwise(true);
			categoryPieChart.setLegendVisible(true);

}
		
	

}
