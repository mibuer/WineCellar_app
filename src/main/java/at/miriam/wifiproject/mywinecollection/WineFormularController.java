package at.miriam.wifiproject.mywinecollection;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ResourceBundle;

import at.miriam.wifiproject.mywinecollection.Wine.WineCategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class WineFormularController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField alcoholTextField;

    @FXML
    private ChoiceBox<String> bottleSizeChoiceBox;

    @FXML
    private TextField chooseImageFilePathTextField;

    @FXML
    private ChoiceBox<String> countryChoiceBox;

    @FXML
    private ChoiceBox<Variety> grapeVarietyChoiceBox;

    @FXML
    private ImageView imageView;

    @FXML
    private TextArea notesTextArea;

    @FXML
    private TextField numberBottlesTextField;

    @FXML
    private TextField pricePerBottleTextField;

    @FXML
    private DatePicker purchaseDatePicker;

    @FXML
    private TextField readyToDrinkTextField;

    @FXML
    private TextField shelfNumberTextField;

    @FXML
    private ChoiceBox<Storage> storageLocationChoiceBox;

    @FXML
    private TextField vineyardTextField;

    @FXML
    private TextField vintageTextField;

    @FXML
    private ChoiceBox<WineCategory> wineCategoryChoiceBox;

    @FXML
    private TextField wineNameTextField;

    @FXML
    private TextField wineProducerTextField;

    @FXML
    private TextArea wineRatingTextArea;

    @FXML
    private TextField wineRegionTextField;

    @FXML
    private TextField wineShopTextField;

    @FXML
    private TextField wineStyleTextField;
    
    @FXML 
    private Button addButton;

    
    

    @FXML
    void onOpenNewImageFileButtonClick(ActionEvent event) {  //Bilddatei hinzufügen
    	
    	FileChooser fileChooser = new FileChooser();
    	File imageFile = fileChooser.showOpenDialog(wineNameTextField.getScene().getWindow());
    	
    	try {
			imageView.setImage(new Image(Files.newInputStream(Path.of(imageFile.getAbsolutePath()))));
			chooseImageFilePathTextField.setText(imageFile.getAbsolutePath());
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void onResetFormButtonClick(ActionEvent event) {  // Reset Form

    	wineNameTextField.setText("");
    	wineProducerTextField.setText("");
    	countryChoiceBox.setValue(null);
    	vintageTextField.setText("");
    	alcoholTextField.setText("");
    	wineRegionTextField.setText("");
    	vineyardTextField.setText("");
    	grapeVarietyChoiceBox.setValue(null);
    	wineCategoryChoiceBox.setValue(null);
    	wineStyleTextField.setText("");
    	readyToDrinkTextField.setText("");
    	chooseImageFilePathTextField.setText("");
    	storageLocationChoiceBox.setValue(null);
    	shelfNumberTextField.setText("");
    	numberBottlesTextField.setText("");
    	bottleSizeChoiceBox.setValue(null);
    	wineShopTextField.setText("");
    	purchaseDatePicker.setValue(null);
    	pricePerBottleTextField.setText("");
    	wineRatingTextArea.setText("");
    	notesTextArea.setText("");
    }

    @FXML
    void onSaveWineButtonClick(ActionEvent event) {  // Wein speichern
    	
    	String name = wineNameTextField.getText();
    	String producer = wineProducerTextField.getText();
    	String country = countryChoiceBox.getValue();
    	String vintage = vintageTextField.getText();
    	String alcohol = alcoholTextField.getText();
    	String wineRegion = wineRegionTextField.getText();
    	String vineyard = vineyardTextField.getText();
    	Variety grapeVariety = grapeVarietyChoiceBox.getValue();
    	WineCategory wineCategory = wineCategoryChoiceBox.getValue();
    	String style = wineStyleTextField.getText();
    	String readyToDrink = readyToDrinkTextField.getText();
    	String filePath = chooseImageFilePathTextField.getText();
    	Storage storage = storageLocationChoiceBox.getValue();
    	String shelfNr = shelfNumberTextField.getText();
    	String numOfBottles = numberBottlesTextField.getText();
    	String bottleSize = bottleSizeChoiceBox.getValue();
    	String shop = wineShopTextField.getText();
    	LocalDate date = purchaseDatePicker.getValue();
    	String price = pricePerBottleTextField.getText();
    	String ratings = wineRatingTextArea.getText();
    	String notes = notesTextArea.getText();
    	
    	Producer producerNew = null;
    	
    	if (!producer.isEmpty()) {
    	producerNew = new Producer(producer, country, wineRegion, vineyard);
    	}
    	
    	//Validierung der Datensätze und Wine Objekt erstellen
    	if (isValidFormInput(name, producer, country, grapeVariety, wineCategory, 
    							storage, numOfBottles, bottleSize)) {
    		
    		Wine wine;
    		
    		try {
				wine = new Wine(name, producerNew, country, wineRegion, vineyard, vintage, alcohol, grapeVariety,
								wineCategory, style, readyToDrink, filePath, imageBytesFromPath(filePath),
								storage, shelfNr, numOfBottles, bottleSize, shop, date, price, ratings, notes);
				System.out.println(wine);
				
				//In der Liste Wines in WineModel speichern
				WineModel.winesList.add(wine);
    		
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    		
    	

    }
    
    private byte[] imageBytesFromPath(String filePath) throws IOException {
		
    	byte[] imageBytes = Files.newInputStream(Path.of(filePath)).readAllBytes();

		return imageBytes;
	}

	//Methode Valdierung Input, Mindestens diese Felder müssen eigegeben werden:
    private boolean isValidFormInput(String name, String producer, String country, Variety variety, 
    								WineCategory category, Storage storage, String numOfBottles, String bottleSize) {
    	
		return !name.isEmpty()
				&& !producer.isEmpty()
				&& !country.isEmpty()
				&& variety != null
				&& category != null
				&& storage != null
				&& !numOfBottles.isEmpty()
				&& !bottleSize.isEmpty();
	}

    @FXML
    void onNewGrapeVarietyButtonClick(ActionEvent event) {
    		
    	//neues Fenster öffnet sich zur Eingabe
    	try {
			new AddGrapeVarietyWindow().show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void onNewStorageLocationButtonClick(ActionEvent event) {

    	//neues Fenster öffnet sich zur Eingabe
    	
    }
    
    //TabPane Tabelle
    
	@FXML
    void onUpdateTableButtonClick(ActionEvent event) {

    }
	
	@FXML
	void onDeleteTableButtonClick(ActionEvent event) {

	}

	
	
	//-----------------------------------------------------------------------------------------------------------
    @FXML
    void initialize() {
    	assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'AddWineView.fxml'.";
    	assert alcoholTextField != null : "fx:id=\"alcoholTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert bottleSizeChoiceBox != null : "fx:id=\"bottleSizeChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert chooseImageFilePathTextField != null : "fx:id=\"chooseImageFilePathTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert countryChoiceBox != null : "fx:id=\"countryChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert grapeVarietyChoiceBox != null : "fx:id=\"grapeVarietyChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert notesTextArea != null : "fx:id=\"notesTextArea\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert numberBottlesTextField != null : "fx:id=\"numberBottlesTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert pricePerBottleTextField != null : "fx:id=\"pricePerBottleTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert purchaseDatePicker != null : "fx:id=\"purchaseDatePicker\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert readyToDrinkTextField != null : "fx:id=\"readyToDrinkTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert shelfNumberTextField != null : "fx:id=\"shelfNumberTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert storageLocationChoiceBox != null : "fx:id=\"storageLocationChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert vineyardTextField != null : "fx:id=\"vineyardTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert vintageTextField != null : "fx:id=\"vintageTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert wineCategoryChoiceBox != null : "fx:id=\"wineCategoryChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert wineNameTextField != null : "fx:id=\"wineNameTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert wineProducerTextField != null : "fx:id=\"wineProducerTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert wineRatingTextArea != null : "fx:id=\"wineRatingTextArea\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert wineRegionTextField != null : "fx:id=\"wineRegionTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert wineShopTextField != null : "fx:id=\"wineShopTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
        assert wineStyleTextField != null : "fx:id=\"wineStyleTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";

        //Country Choice Box erhält Werte
        countryChoiceBox.setItems(WineModel.countryList);
        
        //Variety Choice Box 
        grapeVarietyChoiceBox.setItems(WineModel.varietyList);
        
        //Category Choice Box
        wineCategoryChoiceBox.setItems(WineModel.categoryList);
        
        //StorageLocation Choice Box
        storageLocationChoiceBox.setItems(WineModel.storageList);
        
        //BottleSize Choice Box
        bottleSizeChoiceBox.setItems(WineModel.bottleSizeList);
        
        //disable Button "Speichern" solang nicht die erforderlichen Werte eingetragen sind
        addButton.disableProperty().bind(wineNameTextField.textProperty().isEmpty()
        							.or(wineProducerTextField.textProperty().isEmpty())
        							.or(countryChoiceBox.valueProperty().isNull())
        							.or(grapeVarietyChoiceBox.valueProperty().isNull())
        							.or(wineCategoryChoiceBox.valueProperty().isNull())
        							.or(storageLocationChoiceBox.valueProperty().isNull())
        							.or(numberBottlesTextField.textProperty().isEmpty())
        							.or(bottleSizeChoiceBox.valueProperty().isNull()));
        
    }

}
