package at.miriam.wifiproject.mywinecollection.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import at.miriam.wifiproject.mywinecollection.Constants;
import at.miriam.wifiproject.mywinecollection.model.Producer;
import at.miriam.wifiproject.mywinecollection.model.Purchase;
import at.miriam.wifiproject.mywinecollection.model.Storage;
import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import at.miriam.wifiproject.mywinecollection.model.WineCategory;
import at.miriam.wifiproject.mywinecollection.model.WineModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class AddWineViewController extends BaseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

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
    private Button openImagePathButton;

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
    private Label topLabel;

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
    private ChoiceBox<String> wineStyleChoiceBox;
    
    @FXML
    private Button saveUpdateWineButton;

    
    
    @FXML
    void onSaveUpdateWineButtonClick(ActionEvent event) throws IOException {  //Änderungen speichern

    	System.out.println("In Methode Save Updated Wine");
    	
    	Wine selectedTableRow = model.getSelectedWine();
    	
    	if (selectedTableRow != null ) {

    		String name = wineNameTextField.getText();
        	String producer = wineProducerTextField.getText();
        	String country = countryChoiceBox.getValue();
        	String vintage = vintageTextField.getText();
        	Double alcohol = Double.parseDouble(alcoholTextField.getText());
        	String wineRegion = wineRegionTextField.getText();
        	String vineyard = vineyardTextField.getText();
        	Variety grapeVariety = grapeVarietyChoiceBox.getValue();
        	WineCategory wineCategory = wineCategoryChoiceBox.getValue();
        	String style = wineStyleChoiceBox.getValue();
        	String readyToDrink = readyToDrinkTextField.getText();
        	String filePath = chooseImageFilePathTextField.getText();
        	
        	byte [] imageBytes = getClass().getResourceAsStream(filePath).readAllBytes();
        	
        	Storage storage = storageLocationChoiceBox.getValue();
        	Integer shelfNr = Integer.parseInt(shelfNumberTextField.getText());
        	Integer numOfBottles = Integer.parseInt(numberBottlesTextField.getText());
        	String bottleSize = bottleSizeChoiceBox.getValue();
        	String shop = wineShopTextField.getText();
        	LocalDate date = purchaseDatePicker.getValue();
        	Double price = Double.parseDouble(pricePerBottleTextField.getText());
        	String ratings = wineRatingTextArea.getText();
        	String notes = notesTextArea.getText();
        
        	Producer producerNew = new Producer(0, producer, country, wineRegion, vineyard);
        	
        	
        	
        	Purchase purchaseNew = new Purchase(0, shop, date, price);
        	
        	//Validierung der Datensätze und Wine Objekt erstellen
        	if (isValidFormInput(name, producer, country, grapeVariety, wineCategory, 
        							storage, numOfBottles, bottleSize)) {
        		
        		
        		Wine wine = new Wine(0, name, producerNew, vintage, alcohol, grapeVariety, wineCategory,
								style, readyToDrink, filePath, imageBytes, 
								storage, shelfNr, numOfBottles, bottleSize, purchaseNew, ratings, notes);
				
		
				//alte Daten durch neue ersetzen ->
				//Index des ausgewählten Weins
				int index = model.winesList.indexOf(selectedTableRow);
				
				model.winesList.set(index, wine); //neues Wine Objekt am Index des alten speichern
				
				System.out.println(model.winesList);
        		
        	}
    		
    	}
   
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
    	try {
			new AddStorageWindow().show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void onOpenNewImageFileButtonClick(ActionEvent event) { //Bilddatei hinzufügen
    	
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
    void onResetFormButtonClick(ActionEvent event) { // Reset Form
    	
    	clearForm();
    	
    	
    	
   
    }

    private void clearForm() {
		
    	wineNameTextField.setText("");
    	wineProducerTextField.setText("");
    	countryChoiceBox.setValue(null);
    	vintageTextField.setText("");
    	alcoholTextField.setText("");
    	wineRegionTextField.setText("");
    	vineyardTextField.setText("");
    	grapeVarietyChoiceBox.setValue(null);
    	wineCategoryChoiceBox.setValue(null);
    	wineStyleChoiceBox.setValue(null);
    	readyToDrinkTextField.setText("");
    	chooseImageFilePathTextField.setText("");
    	imageView.setImage(null);
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
    void onSaveWineButtonClick(ActionEvent event) { // Wein speichern

    	String name = wineNameTextField.getText();
    	String producer = wineProducerTextField.getText();
    	String country = countryChoiceBox.getValue();
    	String vintage = vintageTextField.getText();
    	
    	Double alcohol = null;
    	if (alcoholTextField != null) { 
    		
    		try {
    		alcohol = Double.parseDouble(alcoholTextField.getText());
    		} catch (InputMismatchException e) {
    			System.out.println("Please enter a double: 12.5, 13.5, 13.0, ...");
    		}
    	
    	} 
    	
    	String wineRegion = wineRegionTextField.getText();
    	String vineyard = vineyardTextField.getText();
    	Variety grapeVariety = grapeVarietyChoiceBox.getValue();
    	WineCategory wineCategory = wineCategoryChoiceBox.getValue();
    	String style = wineStyleChoiceBox.getValue();
    	String readyToDrink = readyToDrinkTextField.getText();
    	String filePath = chooseImageFilePathTextField.getText();
    	Storage storage = storageLocationChoiceBox.getValue();
    	Integer shelfNr = Integer.parseInt(shelfNumberTextField.getText());
    	Integer numOfBottles = Integer.parseInt(numberBottlesTextField.getText());
    	String bottleSize = bottleSizeChoiceBox.getValue();
    	String shop = wineShopTextField.getText();
    	LocalDate date = purchaseDatePicker.getValue();
    	Double price = Double.parseDouble(pricePerBottleTextField.getText());
    	String ratings = wineRatingTextArea.getText();
    	String notes = notesTextArea.getText();
    	
    	Producer producerNew = null;
    	
    	if (!producer.isEmpty()) {
    	producerNew = new Producer(0, producer, country, wineRegion, vineyard);
    	}
    	
    	
    	Purchase purchaseNew = new Purchase(0, shop, date, price);
    	
    	//Default Foto soll eingestellt sein, falls kein eigenes angegeben wird ???
    	//wurde 1 Foto hinzugefügt -> disable Button
    	
    	
    	//Validierung der Datensätze und Wine Objekt erstellen
    	if (isValidFormInput(name, producer, country, grapeVariety, wineCategory, 
    							storage, numOfBottles, bottleSize)) {
    		
    		Wine wine = null;
    		
    		try {
				wine = new Wine(0, name, producerNew, vintage, alcohol, grapeVariety, wineCategory,
								style, readyToDrink, filePath, imageBytesFromPath(filePath), 
								storage, shelfNr, numOfBottles, bottleSize, purchaseNew, ratings, notes);
				
				System.out.println(wine);
				
				//In der Liste Wines in WineModel speichern
				model.winesList.add(wine);
    		
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    	System.out.println(model.winesList);
    }
    
    private byte[] imageBytesFromPath(String filePath) throws IOException {
		
    	byte[] imageBytes = Files.newInputStream(Path.of(filePath)).readAllBytes();

		return imageBytes;
	}

	//Methode Valdierung Input, Mindestens diese Felder müssen eigegeben werden:
    private boolean isValidFormInput(String name, String producer, String country, Variety variety, 
    								WineCategory category, Storage storage, Integer numOfBottles, String bottleSize) {
    	
		return !name.isEmpty()
				&& !producer.isEmpty()
				&& !country.isEmpty()
				&& variety != null
				&& category != null
				&& storage != null
				&& numOfBottles != null
				&& !bottleSize.isEmpty();
	}

    private void fillForm(Wine wine) {
    	
    	wineNameTextField.setText(wine.getName());
    	wineProducerTextField.setText(wine.getProducer().getName());
    	countryChoiceBox.setValue(wine.getProducer().getCountry());
    	vintageTextField.setText(wine.getVintage());
    	alcoholTextField.setText(String.valueOf(wine.getAlcohol()));
    	wineRegionTextField.setText(wine.getProducer().getWineRegion());
    	vineyardTextField.setText(wine.getProducer().getVineyard());
    	grapeVarietyChoiceBox.setValue(wine.getVariety());
    	wineCategoryChoiceBox.setValue(wine.getWineCategory());
    	wineStyleChoiceBox.setValue(wine.getWineStyle());
    	readyToDrinkTextField.setText(wine.getReadyToDrink());
    	chooseImageFilePathTextField.setText(wine.getImagePath());    	
    	imageView.setImage(loadImage(wine));
    	storageLocationChoiceBox.setValue(wine.getStorage());
    	shelfNumberTextField.setText(String.valueOf(wine.getShelfNumber()));
    	numberBottlesTextField.setText(String.valueOf(wine.getNumberOfBottles()));
    	bottleSizeChoiceBox.setValue(wine.getBottleSize());
    	wineShopTextField.setText(wine.getPurchase().getWineShop());
    	purchaseDatePicker.setValue(wine.getPurchase().getDateOfPurchase());
    	pricePerBottleTextField.setText(String.valueOf(wine.getPurchase().getPrice()));
    	wineRatingTextArea.setText(wine.getWineRatings());
    	notesTextArea.setText(wine.getNotes());
    	
    }
    
    private Image loadImage(Wine wine) {
		
		return new Image(new ByteArrayInputStream(wine.getImageBytes()));
	}

	@FXML
    void initialize() {
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert alcoholTextField != null : "fx:id=\"alcoholTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert bottleSizeChoiceBox != null : "fx:id=\"bottleSizeChoiceBox\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert chooseImageFilePathTextField != null : "fx:id=\"chooseImageFilePathTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert countryChoiceBox != null : "fx:id=\"countryChoiceBox\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert grapeVarietyChoiceBox != null : "fx:id=\"grapeVarietyChoiceBox\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert notesTextArea != null : "fx:id=\"notesTextArea\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert numberBottlesTextField != null : "fx:id=\"numberBottlesTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert openImagePathButton != null : "fx:id=\"openImagePathButton\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert pricePerBottleTextField != null : "fx:id=\"pricePerBottleTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert purchaseDatePicker != null : "fx:id=\"purchaseDatePicker\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert readyToDrinkTextField != null : "fx:id=\"readyToDrinkTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert saveUpdateWineButton != null : "fx:id=\"saveUpdateWineButton\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert shelfNumberTextField != null : "fx:id=\"shelfNumberTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert storageLocationChoiceBox != null : "fx:id=\"storageLocationChoiceBox\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert topLabel != null : "fx:id=\"topLabel\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert vineyardTextField != null : "fx:id=\"vineyardTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert vintageTextField != null : "fx:id=\"vintageTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert wineCategoryChoiceBox != null : "fx:id=\"wineCategoryChoiceBox\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert wineNameTextField != null : "fx:id=\"wineNameTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert wineProducerTextField != null : "fx:id=\"wineProducerTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert wineRatingTextArea != null : "fx:id=\"wineRatingTextArea\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert wineRegionTextField != null : "fx:id=\"wineRegionTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert wineShopTextField != null : "fx:id=\"wineShopTextField\" was not injected: check your FXML file 'AddWineFormView.fxml'.";
        assert wineStyleChoiceBox != null : "fx:id=\"wineStyleChoiceBox\" was not injected: check your FXML file 'AddWineFormView.fxml'.";

        //ImageView soll default Image anzeigen
       // imageView.setImage(new Image (getClass().getResourceAsStream(Constants.PATH_TO_DEFAULT_IMAGE)));
        
        //Country Choice Box erhält Werte
        countryChoiceBox.setItems(model.countryList);
        
        //Variety Choice Box 
        grapeVarietyChoiceBox.setItems(model.varietyList);
        
        //Category Choice Box
        wineCategoryChoiceBox.setItems(model.categoryList);
        
        //wineStyleChoiceBox
        wineStyleChoiceBox.setItems(model.wineStylesList);
        
        //StorageLocation Choice Box
        storageLocationChoiceBox.setItems(model.storageList);
        
        //BottleSize Choice Box
        bottleSizeChoiceBox.setItems(model.bottleSizeList);
        
        //disable Button "Speichern" solang nicht die erforderlichen Werte eingetragen sind
        addButton.disableProperty().bind(wineNameTextField.textProperty().isEmpty()
        							.or(wineProducerTextField.textProperty().isEmpty())
        							.or(countryChoiceBox.valueProperty().isNull())
        							.or(grapeVarietyChoiceBox.valueProperty().isNull())
        							.or(wineCategoryChoiceBox.valueProperty().isNull())
        							.or(storageLocationChoiceBox.valueProperty().isNull())
        							.or(numberBottlesTextField.textProperty().isEmpty())
        							.or(bottleSizeChoiceBox.valueProperty().isNull()));
       
       //Anzeigen des in der Tabelle ausgewählten Weins in der "AddWineView"
       model.selectedWineProperty().addListener(new ChangeListener<Wine>() {

    	 @Override
    	 public void changed(ObservableValue<? extends Wine> observable, Wine oldValue, Wine newValue) {
			
			if (newValue != null) {
				fillForm(newValue);
			}
		
			
		}
       });
        
        
        
        
        
        
        
        
        
    }

}
