package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.util.ResourceBundle;

import at.miriam.wifiproject.mywinecollection.model.Wine;
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
        
        
        favoritesListView.getItems().addAll(model.favWinesList);
        
        
        //favWines werden bei Start des Programms aus der Datenbank gelesen

    }

    
    
    
}
