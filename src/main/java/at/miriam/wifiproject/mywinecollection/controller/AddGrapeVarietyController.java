package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.util.ResourceBundle;

import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.WineModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddGrapeVarietyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label newVarietyLabel;

    @FXML
    private TextField newVarietyTextField;

    @FXML
    void onNewVarietySaveButtonClick(ActionEvent event) { //Neue Rebsorte eingeben und im Model speichern
    	
    	Variety variety = new Variety();
    	
    	String name = newVarietyTextField.getText();
    	
    	variety.setName(name);
    	
    	WineModel.varietyList.add(variety);

    	
    }

    @FXML
    void onResetFormVarietyButtonClick(ActionEvent event) { // Reset Form
    	
    	newVarietyTextField.setText("");

    }

    @FXML
    void initialize() {
        assert newVarietyLabel != null : "fx:id=\"newVarietyLabel\" was not injected: check your FXML file 'AddGrapeVarietyView.fxml'.";
        assert newVarietyTextField != null : "fx:id=\"newVarietyTextField\" was not injected: check your FXML file 'AddGrapeVarietyView.fxml'.";
        
    }

}
