package at.miriam.wifiproject.mywinecollection;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ResourceBundle;

import at.miriam.wifiproject.mywinecollection.Wine.WineCategory;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

public class WineFormularController {
	
	//TabPane Wein
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
    private Label topLabel;
    
    @FXML 
	private Button openImagePathButton;
    
    //TabPane Tabelle 
    @FXML TableView<Wine> tableView;

	@FXML 
	private TableColumn<Wine, Button> favouritesColumn;

	@FXML 
	private TableColumn<Wine, WineCategory> categoryColumn;

	@FXML 
	private TableColumn<Wine, String> wineStyleColumn;

	@FXML 
	private TableColumn<Wine, Variety> varietyColumn;

	@FXML 
	private TableColumn<Wine, String> nameColumn;

	@FXML 
	private TableColumn<Wine, Producer> producerColumn;

	@FXML 
	private TableColumn<Wine, String> vintageColumn;

	@FXML 
	private TableColumn<Wine, String> alcoholColumn;

	@FXML 
	private TableColumn<Wine, String> countryColumn;

	@FXML 
	private TableColumn<Wine, String> regionColumn;

	@FXML 
	private TableColumn<Wine, String> vineyardColumn;

	@FXML 
	private TableColumn<Wine, Storage> storageColumn;

	@FXML 
	private TableColumn<Wine, String> shelfNrColumn;

	@FXML 
	private TableColumn<Wine, String> numOfBottlesColumn;

	@FXML 
	private TableColumn<Wine, String> bottleSizeColumn;

	@FXML 
	private TableColumn<Wine, String> shopColumn;

	@FXML 
	private TableColumn<Wine, LocalDate> dateColumn;

	@FXML 
	private TableColumn<Wine, String> priceColumn;
	
	@FXML
    private TableColumn<Wine, String> readyToDrinkColumn;

	
	
	//TabPane Wein
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
    	
    	//Default Foto soll eingestellt sein, falls kein eigenes angegeben wird ???
    	//wurde 1 Foto hinzugefügt -> disable Button
    	
    	
    	//Validierung der Datensätze und Wine Objekt erstellen
    	if (isValidFormInput(name, producer, country, grapeVariety, wineCategory, 
    							storage, numOfBottles, bottleSize)) {
    		
    		Wine wine = null;
    		
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
    	try {
			new AddStorageWindow().show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    //TabPane Tabelle
    
	@FXML
    void onUpdateTableButtonClick(ActionEvent event) {
		
		tableView.setEditable(true);
		
		
    }
	
	@FXML
	void onDeleteTableButtonClick(ActionEvent event) {
			
		tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
	}

	
	
	//-----------------------------------------------------------------------------------------------------------
    @FXML
    void initialize() {
    	 assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert alcoholColumn != null : "fx:id=\"alcoholColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert alcoholTextField != null : "fx:id=\"alcoholTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert bottleSizeChoiceBox != null : "fx:id=\"bottleSizeChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert bottleSizeColumn != null : "fx:id=\"bottleSizeColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert categoryColumn != null : "fx:id=\"categoryColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert chooseImageFilePathTextField != null : "fx:id=\"chooseImageFilePathTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert countryChoiceBox != null : "fx:id=\"countryChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert countryColumn != null : "fx:id=\"countryColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert dateColumn != null : "fx:id=\"dateColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert favouritesColumn != null : "fx:id=\"favouritesColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert grapeVarietyChoiceBox != null : "fx:id=\"grapeVarietyChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert notesTextArea != null : "fx:id=\"notesTextArea\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert numOfBottlesColumn != null : "fx:id=\"numOfBottlesColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert numberBottlesTextField != null : "fx:id=\"numberBottlesTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert openImagePathButton != null : "fx:id=\"openImagePathButton\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert priceColumn != null : "fx:id=\"priceColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert pricePerBottleTextField != null : "fx:id=\"pricePerBottleTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert producerColumn != null : "fx:id=\"producerColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert purchaseDatePicker != null : "fx:id=\"purchaseDatePicker\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert readyToDrinkColumn != null : "fx:id=\"readyToDrinkColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert readyToDrinkTextField != null : "fx:id=\"readyToDrinkTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert regionColumn != null : "fx:id=\"regionColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert shelfNrColumn != null : "fx:id=\"shelfNrColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert shelfNumberTextField != null : "fx:id=\"shelfNumberTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert shopColumn != null : "fx:id=\"shopColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert storageColumn != null : "fx:id=\"storageColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert storageLocationChoiceBox != null : "fx:id=\"storageLocationChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert topLabel != null : "fx:id=\"topLabel\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert varietyColumn != null : "fx:id=\"varietyColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert vineyardColumn != null : "fx:id=\"vineyardColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert vineyardTextField != null : "fx:id=\"vineyardTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert vintageColumn != null : "fx:id=\"vintageColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert vintageTextField != null : "fx:id=\"vintageTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert wineCategoryChoiceBox != null : "fx:id=\"wineCategoryChoiceBox\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert wineNameTextField != null : "fx:id=\"wineNameTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert wineProducerTextField != null : "fx:id=\"wineProducerTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert wineRatingTextArea != null : "fx:id=\"wineRatingTextArea\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert wineRegionTextField != null : "fx:id=\"wineRegionTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert wineShopTextField != null : "fx:id=\"wineShopTextField\" was not injected: check your FXML file 'AddWineView.fxml'.";
         assert wineStyleColumn != null : "fx:id=\"wineStyleColumn\" was not injected: check your FXML file 'AddWineView.fxml'.";
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
      
        //Wein zur Tabelle hinzufügen
        String imagePath = "/at/miriam/wifiproject/mywinecollection/Images/default_image.png";
    	byte[] imageBytes = null;
		try {
			imageBytes = getClass().getResourceAsStream(imagePath).readAllBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Wine wine = new Wine("Wiener Gemischter Satz DAC", 
    						new Producer("Stift Klosterneuburg", "AT", "Wien", "Nussberg"), 
    						"AT", "2021", "12,5", "Wien", "Nussberg", 
    						new Variety("Gemischter Satz"), WineCategory.WEISS, 
    						"leicht, fruchtig", "2023", 
    						imagePath, imageBytes, 
    						new Storage("Keller 1", 2), "2", "6", "0,75", "Vinothek", LocalDate.of(2022, 3, 15), "8.90", "falstaff 93", "Geburtstagsparty");
        WineModel.winesList.add(wine);
        
        //Tabelle
        tableView.setItems(WineModel.winesList);
        //Erste Spalte: Button, um Wein als Favoriten auszuwählen, Favorit wird in einer Liste im WineModel gespeichert
        //Farbe des Buttons ändert sich, sobald in Favoriten Liste gespeichert
        favouritesColumn.setCellFactory(new Callback< TableColumn<Wine,Button>, TableCell<Wine,Button> >() {
			
			@Override
			public TableCell<Wine, Button> call(TableColumn<Wine, Button> param) {
				
				TableCell<Wine, Button> cell = new TableCell<>() {
					Button favButton = new Button("F");
					
					protected void updateItem(Button item, boolean empty) {
						super.updateItem(item, empty);
						
						if(empty) {
							setGraphic(null);
							setText(null);
						} else {
							favButton.setOnAction(event -> {
								Wine wine = getTableView().getItems().get(getIndex());
								//Wenn die Favoriten Liste das Element schon erhält, nicht hinzufügen
								//Liste darf max 5 Positionen haben
								
								
								WineModel.favWinesList.add(wine);
								
							});
							setGraphic(favButton);
							setText(null);
						}
					};
				};
				
				return cell;
			}
			
		}); // Ende FavoritesColumn
        
        //TableColumns die Wine Attribute zuweisen mit Cell Value Factory
        //Kategorie
        categoryColumn.setCellValueFactory(data -> new SimpleObjectProperty<WineCategory>(data.getValue().getWineCategory()));
        //Bezeichnung
        nameColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getName()));
        //Hersteller
        producerColumn.setCellValueFactory(data -> new SimpleObjectProperty<Producer>(data.getValue().getProducer()));
        //Jahrgang
        vintageColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getVintage()));
        //Land
        countryColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getCountry()));
        //Weinregion
        regionColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getWineRegion()));
        //Lage
        vineyardColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getVineyard()));
        //Rebsorte
        varietyColumn.setCellValueFactory(data -> new SimpleObjectProperty<Variety>(data.getValue().getVariety()));
        //Alkoholgehalt
        alcoholColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getAlcohol()));
        //Weinstil
        wineStyleColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getWineStyle()));
        //Trinkreife
        readyToDrinkColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getReadyToDrink()));
        //Lagerort
        storageColumn.setCellValueFactory(data -> new SimpleObjectProperty<Storage>(data.getValue().getStorageLocation()));
        //RegalNummer
        shelfNrColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getShelfNumber()));
        //Menge Flaschen
        numOfBottlesColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getBottleNumber()));
        //Flaschen Größe
        bottleSizeColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getBottleSize()));
        //Händler
        shopColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getBottleSize()));
        //Datum
        dateColumn.setCellValueFactory(data -> new SimpleObjectProperty<LocalDate>(data.getValue().getDateOfPurchase()));
        //Preis
        priceColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrice()));
        
        
        
        
        
    } //--------------------------------------------------------------------------------------

    
    
}
