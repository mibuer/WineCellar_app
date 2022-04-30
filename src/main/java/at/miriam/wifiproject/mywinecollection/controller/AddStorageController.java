package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.util.ResourceBundle;

import at.miriam.wifiproject.mywinecollection.model.Storage;
import at.miriam.wifiproject.mywinecollection.model.WineModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddStorageController extends BaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label newStorageLabel;

    @FXML
    private TextField newStorageTextField;

    @FXML
    void onNewStorageResetButtonClick(ActionEvent event) {
    	
    	newStorageTextField.setText("");
    	
    }

    @FXML
    void onNewStorageSaveButtonClick(ActionEvent event) {

    	Storage storage = new Storage();
    	
    	String storageName = newStorageTextField.getText();
    	
    	storage.setName(storageName);
    	
    	model.storageList.add(storage);
    	
    	

    }

    @FXML
    void initialize() {
        assert newStorageLabel != null : "fx:id=\"newStorageLabel\" was not injected: check your FXML file 'AddStorageView.fxml'.";
        assert newStorageTextField != null : "fx:id=\"newStorageTextField\" was not injected: check your FXML file 'AddStorageView.fxml'.";

    }

}
