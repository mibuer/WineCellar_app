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
import at.miriam.wifiproject.mywinecollection.model.WineCategory;
import at.miriam.wifiproject.mywinecollection.model.WineModel;
import at.miriam.wifiproject.mywinecollection.repository.ProducerRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.PurchaseRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.StorageRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.VarietyRepository;
import at.miriam.wifiproject.mywinecollection.repository.VarietyRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.WineRepositoryJPA;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    @Override
    public void init() throws Exception {
    	
    	super.init();
    	
    	initWineModel();
    	
//    	WineRepositoryJPA.setupDatabaseConnection();
//    	ProducerRepositoryJPA.setupDatabaseConnection();
//    	StorageRepositoryJPA.setupDatabaseConnection();
//    	VarietyRepositoryJPA.setupDatabaseConnection();
//    	PurchaseRepositoryJPA.setupDatabaseConnection();
    	
    	
    }
    
    private void initWineModel() throws IOException {
		
//    	String imagePath = Constants.PATH_TO_DEFAULT_IMAGE;
//    	byte[] imageBytes = null;
//		
//		imageBytes = getClass().getResourceAsStream(imagePath).readAllBytes();
//	
//    	Wine wine1 = new Wine(0, "Wiener Gemischter Satz DAC", new Producer(0, "Stift Klosterneuburg", "AT", "Wien", "Nussberg"), 
//    						"2021", 12.5, new Variety(0, "Gemischter Satz"), WineCategory.WEISS, 
//    						"leicht, fruchtig", "2023", imagePath, imageBytes, 
//    						new Storage(0, "Keller 1"),2, 6, "0,75", new Purchase(0, "Vinothek", LocalDate.of(2022, 3, 15), 9.80),
//    						"falstaff 93", "Geburtstagsparty");
//    	
//    	Wine wine2 = new Wine(0, "Rosé Piaristisch", new Producer(0, "Pia Strehn", "AT", "Mittelburgenland", "Deutschkreutz"), 
//				"2021", 12.5, new Variety(0, "Cuvée"), WineCategory.ROSE, 
//				"leicht, fruchtig", "2023", imagePath, imageBytes, 
//				new Storage(0, "Keller 2"), 5, 1, "0,75", new Purchase(0, "Wein&Co", LocalDate.of(2022, 4, 3), 10.00),
//				"falstaff 93", "Geburtstagsparty");
//    	
//    	Wine wine3 = new Wine(0, "Beaune du Château 1er Cru", new Producer(0, "Bouchard Père & Fils", "FR", "Burgund", "Beaune AOC"), 
//				"2018", 13.0, new Variety(0, "Pinot Noir"), WineCategory.ROT, 
//				"voll", "bis 2030", imagePath, imageBytes, 
//				new Storage(0, "Keller"), 2, 6, "0,75", new Purchase(0, "Wein&Co", LocalDate.of(2022, 7, 4), 40.00),
//				"", "Pinot Cuvée aus 17 Premier-Cru Lagen");
//    	
//    	Wine wine4 = new Wine(0, "Chianti Classico Riserva Rocca Giucciarda", new Producer(0, "Barone Ricasoli", "IT", "Toskana", "Chianti Classico DOCG"), 
//				"2019", 13.5, new Variety(0, "Sangiovese"), WineCategory.ROT, 
//				"voll", "bis 2031", imagePath, imageBytes, 
//				new Storage(0, "Klimaschrank"), 2, 3, "0,75", new Purchase(0, "Wein&Co", LocalDate.of(2022, 4, 18), 19.95),
//				"", "Barrique Ausbau 20 Monate");
//    	
//    	
//        WineModel.initWines.add(wine1);
//        WineModel.initWines.add(wine2);
//        WineModel.initWines.add(wine3);
//        WineModel.initWines.add(wine4);
    	
		
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