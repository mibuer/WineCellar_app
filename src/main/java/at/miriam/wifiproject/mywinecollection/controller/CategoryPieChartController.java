package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import at.miriam.wifiproject.mywinecollection.model.Wine;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class CategoryPieChartController extends BaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart categoryPieChart;

    @FXML
    void initialize() {
        assert categoryPieChart != null : "fx:id=\"categoryPieChart\" was not injected: check your FXML file 'CategoryPieChartView.fxml'.";

        //Anzahl der Weine in den verschiedenen Kategorien aus model.winesList
        
      List<Wine> listCategories = model.winesList.stream()
        					.filter(c -> c.getWineCategory() != null)
        					.collect(Collectors.toList());
        
      ObservableList<PieChart.Data> categoryPieChartData = FXCollections.observableArrayList();  
      
      PieChart.Data categoryData = null;
      
      for (int i=0; i < listCategories.size(); i++) {
  		
  		categoryData = new PieChart.Data(listCategories.get(i).toString(), Double.valueOf(i));
  		categoryPieChartData.add(categoryData);
  	}
//      
//        FilteredList<Wine> categoryWEISS = new FilteredList<>(model.winesList, data -> data.getWineCategory() != null);
//        int indexWEISS = categoryWEISS.size();
//        //System.out.println(indexWEISS);
//        FilteredList<Wine> categoryROT = new FilteredList<>(model.winesList, data -> data.getWineCategory().ROT != null);
//        int indexROT = categoryROT.size();
//        //System.out.println(categoryROT);
//        FilteredList<Wine> categoryROSE = new FilteredList<>(model.winesList, data -> data.getWineCategory().ROSE != null);
//        int indexROSE = categoryROSE.size();
//       
//        
//        
//        
//        
//        ObservableList<PieChart.Data> categoryPieChartData = FXCollections.observableArrayList(
//        						new PieChart.Data("WEISS", Double.valueOf(indexWEISS)),
//        						new PieChart.Data("ROT", Double.valueOf(indexROT)),
//        						new PieChart.Data("ROSÉ", Double.valueOf(indexROSE)));
        
        categoryPieChart.setData(categoryPieChartData);
        categoryPieChart.setTitle("Weinbestand nach Kategorien");
        categoryPieChart.setClockwise(true);
        categoryPieChart.setLegendVisible(false);
     
       
        
    }

}
