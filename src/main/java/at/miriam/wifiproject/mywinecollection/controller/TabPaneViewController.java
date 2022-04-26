package at.miriam.wifiproject.mywinecollection.controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;

import at.miriam.wifiproject.mywinecollection.model.Wine;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TabPaneViewController extends BaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label bottleNumLabel;

    @FXML
    private Label logoLabel;

    @FXML
    private Label valueCollectionLabel;
    
    @FXML
    private ImageView logoImageView;

    @FXML
    void initialize() {
        assert bottleNumLabel != null : "fx:id=\"bottleNumLabel\" was not injected: check your FXML file 'TabPaneView.fxml'.";
        assert logoImageView != null : "fx:id=\"logoImageView\" was not injected: check your FXML file 'TabPaneView.fxml'.";
        assert logoLabel != null : "fx:id=\"logoLabel\" was not injected: check your FXML file 'TabPaneView.fxml'.";
        assert valueCollectionLabel != null : "fx:id=\"valueCollectionLabel\" was not injected: check your FXML file 'TabPaneView.fxml'.";


       //Gesamtanzahl der Flaschen
       bottleNumLabel.setText("12345");
       //Gesamtwert der Collection 
       valueCollectionLabel.setText(getValueOfCollection());
       
        
    }

	private String getValueOfCollection() {
		
		//Gesamtwert pro Wein-Objekt 
		//valueBottle * numOfBottles = valueWine
		
		//Gesamtwert aller Flaschen
		//valueWine * numOfWineObjects = valueCollection 
		
		
		
		return null;
	}

	private String getNumberOfBottles() {
		
		//Flaschenanzahl gesamt
		
		return null;
	}

}
