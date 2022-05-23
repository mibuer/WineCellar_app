package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import at.miriam.wifiproject.mywinecollection.model.Wine;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class FavListViewController extends BaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Wine> favoritesListView;
    
  

    @FXML
    void initialize() {
        assert favoritesListView != null : "fx:id=\"favoritesListView\" was not injected: check your FXML file 'FavoritesListView.fxml'.";
        
        
//		List<Wine> winesSorted = model.winesList.sorted((w1, w2) -> w1.getVintage().compareTo(w2.getVintage()));
//		
//        favoritesListView.getItems().addAll(winesSorted);
//        System.out.println(winesSorted);
        
        updateListView();

    }


	private void updateListView() {
		 
			model.favWinesList.addListener(new ListChangeListener<Wine>() {

				@Override
				public void onChanged(Change<? extends Wine> c) {
					
					if (favoritesListView != null) {
						
						for (Wine wine : model.favWinesList) {
							 favoritesListView.getItems().remove(wine);
						}
					}
					
					favoritesListView.getItems().addAll(model.favWinesList);
					
			        System.out.println(model.favWinesList);	
				}
	        	
	        });
		
		
	}


    
}
