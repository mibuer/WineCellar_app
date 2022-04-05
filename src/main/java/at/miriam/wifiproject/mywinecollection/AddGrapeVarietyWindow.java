package at.miriam.wifiproject.mywinecollection;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddGrapeVarietyWindow {
	
	void show() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/at/miriam/wifiproject/mywinecollection/FXML/AddGrapeVarietyView.fxml"));
		
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}

}
