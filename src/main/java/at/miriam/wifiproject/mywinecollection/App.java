package at.miriam.wifiproject.mywinecollection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import at.miriam.wifiproject.mywinecollection.model.Producer;
import at.miriam.wifiproject.mywinecollection.model.Purchase;
import at.miriam.wifiproject.mywinecollection.model.Storage;
import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import at.miriam.wifiproject.mywinecollection.model.WineModel;
import at.miriam.wifiproject.mywinecollection.model.Wine.WineCategory;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    @Override
    public void init() throws Exception {
    	
    	super.init();
    	initWineModel();
    	System.out.println("Before App started");
    	
    }
    
    private void initWineModel() throws IOException {
		
    	String imagePath = Constants.PATH_TO_DEFAULT_IMAGE;
    	byte[] imageBytes = null;
		
		imageBytes = getClass().getResourceAsStream(imagePath).readAllBytes();
	
    	Wine wine1 = new Wine("Wiener Gemischter Satz DAC", new Producer("Stift Klosterneuburg", "AT", "Wien", "Nussberg"), 
    						"2021", "12,5", new Variety("Gemischter Satz"), WineCategory.WEISS, 
    						"leicht, fruchtig", "2023", imagePath, imageBytes, 
    						new Storage("Keller 1", "2", "6", "0,75"), new Purchase("Vinothek", LocalDate.of(2022, 3, 15), "9,80"),
    						"falstaff 93", "Geburtstagsparty");
    	
    	Wine wine2 = new Wine("Rosé Piaristisch", new Producer("Pia Strehn", "AT", "Mittelburgenland", "Deutschkreutz"), 
				"2021", "12,5", new Variety("Cuvée"), WineCategory.ROSE, 
				"leicht, fruchtig", "2023", imagePath, imageBytes, 
				new Storage("Keller 2", "5", "1", "0,75"), new Purchase("Wein&Co", LocalDate.of(2022, 4, 3), "10,00"),
				"falstaff 93", "Geburtstagsparty");
    	
    	
        WineModel.initWines.add(wine1);
        WineModel.initWines.add(wine2);
		
	}



	@Override
    public void start(Stage stage) throws IOException {
        
		System.out.println("App started");
		scene = new Scene(loadFXML(""));      
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(Constants.PATH_TO_TAB_PANE_VIEW));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}