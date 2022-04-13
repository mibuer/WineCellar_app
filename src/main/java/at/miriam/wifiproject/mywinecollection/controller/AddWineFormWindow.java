package at.miriam.wifiproject.mywinecollection.controller;

import java.io.IOException;

import at.miriam.wifiproject.mywinecollection.Constants;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddWineFormWindow {

	
	public void showWindow(Stage lastStage) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource(Constants.PATH_TO_ADD_WINE_FORM_VIEW));
		
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.showAndWait();
		
	}
	
	
}
