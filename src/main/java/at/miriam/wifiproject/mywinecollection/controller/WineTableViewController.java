package at.miriam.wifiproject.mywinecollection.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import at.miriam.wifiproject.mywinecollection.model.Producer;
import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import at.miriam.wifiproject.mywinecollection.model.WineCategory;
import at.miriam.wifiproject.mywinecollection.repository.WineRepository;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
		private TableColumn<Wine, Double> alcoholColumn;

		@FXML 
		private TableColumn<Wine, String> countryColumn;

		@FXML 
		private TableColumn<Wine, String> regionColumn;

		@FXML 
		private TableColumn<Wine, String> vineyardColumn;

		@FXML 
		private TableColumn<Wine, String> storageColumn;

		@FXML 
		private TableColumn<Wine, Integer> shelfNrColumn;

		@FXML 
		private TableColumn<Wine, Integer> numOfBottlesColumn;

		@FXML 
		private TableColumn<Wine, String> bottleSizeColumn;

		@FXML 
		private TableColumn<Wine, String> shopColumn;

		@FXML 
		private TableColumn<Wine, LocalDate> dateColumn;

		@FXML 
		private TableColumn<Wine, Double> priceColumn;
		
		@FXML
	    private TableColumn<Wine, String> readyToDrinkColumn;
		
		@FXML
	    private Label selectedWineLabel;

		@FXML 
		private Label filterTableLabel;

		@FXML 
		private TextField filterTableTextField;
		
    
    @FXML
    void onDeleteTableButtonClick(ActionEvent event) {

    	Wine wine = model.getSelectedWine();
    	if (wine != null) {
    		model.winesList.remove(wine);
    				
    	}
    	
    }

    @FXML
    void onUpdateTableButtonClick(ActionEvent event) throws IOException {   
    	
    	// zurück zu tab pane Wein, hier daten ändern
    	//FXMLLoader.load(getClass().getResource(Constants.PATH_TO_ADD_WINE_FORM_VIEW)); 
    	//Tab text="Wein"
    	
    }
    
//    private Window getWindow() {
//		
//		return selectedWineLabel.getScene().getWindow();
//	}

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
								favButton.setStyle("-fx-background-color: yellow");
								System.out.println(model.favWinesList.toString());
								
								
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
        alcoholColumn.setCellValueFactory(data -> new SimpleObjectProperty<Double>(data.getValue().getAlcohol()));
        //Weinstil
        wineStyleColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getWineStyle()));
        //Trinkreife
        readyToDrinkColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getReadyToDrink()));
        //Lagerort
        storageColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getStorage().getName()));
        //RegalNummer
        shelfNrColumn.setCellValueFactory(data -> new SimpleObjectProperty<Integer>(data.getValue().getShelfNumber()));
        //Menge Flaschen
        numOfBottlesColumn.setCellValueFactory(data -> new SimpleObjectProperty<Integer>(data.getValue().getNumberOfBottles()));
        //Flaschen Größe
        bottleSizeColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getBottleSize()));
        //Händler
        shopColumn.setCellValueFactory(data -> new SimpleObjectProperty<String>(data.getValue().getPurchase().getWineShop()));
        //Datum
        dateColumn.setCellValueFactory(data -> new SimpleObjectProperty<LocalDate>(data.getValue().getPurchase().getDateOfPurchase()));
        //Preis
        priceColumn.setCellValueFactory(data -> new SimpleObjectProperty<Double>(data.getValue().getPurchase().getPrice()));
        
       
        model.selectedWineProperty().bind(tableView.getSelectionModel().selectedItemProperty());
        
        //TableView Filter
        //ObservableList in FilteredList packen, diese kann mit Predicate gefiltert werden
        FilteredList<Wine> filteredList = new FilteredList<>(model.winesList, p -> true); 
        
        filterTableTextField.textProperty().addListener((observable, oldValue, newValue) -> { 
        						filteredList.setPredicate( data -> { //Eingabe ins Textfield wird als Predicate übergeben
        							
        							if(newValue == null || newValue.isEmpty()) {
        								return true; //Tabelle soll angezeigt werden, wenn keine Eingabe im Textfield erfolgt
        							}
        							
        							String lowerCaseFilter = newValue.toLowerCase(); //Filter erstellen, returns true wenn String mit dem Predicate übereinstimmt
        																			//ansonsten return false, keine Übereinstimmung gefunden
        							if (data.getName().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getProducer().getName().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getVintage().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getProducer().getCountry().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getProducer().getVineyard().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getAlcohol().toString().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getVariety().toString().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getWineStyle().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getReadyToDrink().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getStorage().getName().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getBottleSize().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getPurchase().getWineShop().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getProducer().getWineRegion().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getNumberOfBottles().toString().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getPurchase().getPrice().toString().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getPurchase().getDateOfPurchase().toString().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							} else if (data.getWineCategory().toString().toLowerCase().contains(lowerCaseFilter)) {
        								return true;
        							}
        							
        							return false;
        							
        						});
        });
        
        //FilteredList in SortedList speichern, da unmodifiable
        SortedList<Wine> sortedData = new SortedList<>(filteredList);
        
        //SortedList über Property an TableView binden
        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        
        tableView.setItems(sortedData);
        
    }

}
