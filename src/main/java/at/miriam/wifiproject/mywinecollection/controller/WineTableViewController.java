package at.miriam.wifiproject.mywinecollection.controller;

import java.io.IOException;
import java.time.LocalDate;

import at.miriam.wifiproject.mywinecollection.model.Producer;
import at.miriam.wifiproject.mywinecollection.model.Purchase;
import at.miriam.wifiproject.mywinecollection.model.Storage;
import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import at.miriam.wifiproject.mywinecollection.model.WineModel;
import at.miriam.wifiproject.mywinecollection.model.Wine.WineCategory;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

public class WineTableViewController extends BaseController {

	  	@FXML 
	  	private TableView<Wine> tableView;

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
		private TableColumn<Wine, String> storageColumn;

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
		
		@FXML
	    private Label selectedWineLabel;
		
    
    @FXML
    void onDeleteTableButtonClick(ActionEvent event) {

    	//tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
    	Wine wine = model.getSelectedWine();
    	if (wine != null) {
    		model.winesList.remove(wine);
    		model.setSelectedWine(null);
    		
    	}
    	
    }

    @FXML
    void onUpdateTableButtonClick(ActionEvent event) {  //Wein ändern, AddWineView öffnet sich 
    	
    	//TableRow in der Tabelle auswählen
    	Wine selectedTableRow = model.getSelectedWine();
    	//click on Button "Ändern" -> AddWineView öffnet sich
    	//showWindow() bekommt Stage 
    	try {
			new AddWineFormWindow().showWindow((Stage)getWindow());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	//Im AddWineViewController -->
    	//Werte werden im Formular angezeigt -> ändern
    	//Button click "Änderungen speichern"
    	//wenn keine Änderungen gemacht werden -> disable Button Änderungen speichern 
    	

    }
    
    private Window getWindow() {
		
		return selectedWineLabel.getScene().getWindow();
	}

	@FXML
    void initialize() {
        assert alcoholColumn != null : "fx:id=\"alcoholColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert bottleSizeColumn != null : "fx:id=\"bottleSizeColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert categoryColumn != null : "fx:id=\"categoryColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert countryColumn != null : "fx:id=\"countryColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert dateColumn != null : "fx:id=\"dateColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert favouritesColumn != null : "fx:id=\"favouritesColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert numOfBottlesColumn != null : "fx:id=\"numOfBottlesColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert priceColumn != null : "fx:id=\"priceColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert producerColumn != null : "fx:id=\"producerColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert readyToDrinkColumn != null : "fx:id=\"readyToDrinkColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert regionColumn != null : "fx:id=\"regionColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert selectedWineLabel != null : "fx:id=\"selectedWineLabel\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert shelfNrColumn != null : "fx:id=\"shelfNrColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert shopColumn != null : "fx:id=\"shopColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert storageColumn != null : "fx:id=\"storageColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert varietyColumn != null : "fx:id=\"varietyColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert vineyardColumn != null : "fx:id=\"vineyardColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert vintageColumn != null : "fx:id=\"vintageColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";
        assert wineStyleColumn != null : "fx:id=\"wineStyleColumn\" was not injected: check your FXML file 'WineTableView.fxml'.";

      
        //Wein zur Tabelle hinzufügen
       
        
//        String imagePath = "/at/miriam/wifiproject/mywinecollection/Images/default_image.png";
//    	byte[] imageBytes = null;
//		try {
//			imageBytes = getClass().getResourceAsStream(imagePath).readAllBytes();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//    	Wine wine = new Wine("Wiener Gemischter Satz DAC", new Producer("Stift Klosterneuburg", "AT", "Wien", "Nussberg"), 
//    						"2021", "12,5", new Variety("Gemischter Satz"), WineCategory.WEISS, 
//    						"leicht, fruchtig", "2023", imagePath, imageBytes, 
//    						new Storage("Keller 1", "2", "6", "0,75"), new Purchase("Vinothek", LocalDate.of(2022, 3, 15), "9,80"),
//    						"falstaff 93", "Geburtstagsparty");
//        WineModel.winesList.add(wine);
        
        //Tabelle
        tableView.setItems(model.winesList);
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
								
								
								model.favWinesList.add(wine);
								
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
        countryColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getProducer().getCountry()));
        //Weinregion
        regionColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getProducer().getWineRegion()));
        //Lage
        vineyardColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getProducer().getVineyard()));
        //Rebsorte
        varietyColumn.setCellValueFactory(data -> new SimpleObjectProperty<Variety>(data.getValue().getVariety()));
        //Alkoholgehalt
        alcoholColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getAlcohol()));
        //Weinstil
        wineStyleColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getWineStyle()));
        //Trinkreife
        readyToDrinkColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getReadyToDrink()));
        //Lagerort
        storageColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getStorage().getName()));
        //RegalNummer
        shelfNrColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getStorage().getShelfNumber()));
        //Menge Flaschen
        numOfBottlesColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getStorage().getBottleNumber()));
        //Flaschen Größe
        bottleSizeColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getStorage().getBottleSize()));
        //Händler
        shopColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getPurchase().getWineShop()));
        //Datum
        dateColumn.setCellValueFactory(data -> new SimpleObjectProperty<LocalDate>(data.getValue().getPurchase().getDateOfPurchase()));
        //Preis
        priceColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPurchase().getPrice()));
        
        
       
        model.selectedWineProperty().bind(tableView.getSelectionModel().selectedItemProperty());
        
        
    }

}
