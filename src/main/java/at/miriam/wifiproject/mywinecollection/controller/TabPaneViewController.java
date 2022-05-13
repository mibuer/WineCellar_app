package at.miriam.wifiproject.mywinecollection.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import at.miriam.wifiproject.mywinecollection.model.Wine;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class TabPaneViewController extends BaseController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label bottleNumLabel;

	@FXML
	private Label logoLabel;

	@FXML
	private Label valueCollectionLabel;

	@FXML
	private ImageView logoImageView;

	@FXML
	void initialize() {
		assert bottleNumLabel != null
				: "fx:id=\"bottleNumLabel\" was not injected: check your FXML file 'TabPaneView.fxml'.";
		assert logoImageView != null
				: "fx:id=\"logoImageView\" was not injected: check your FXML file 'TabPaneView.fxml'.";
		assert logoLabel != null : "fx:id=\"logoLabel\" was not injected: check your FXML file 'TabPaneView.fxml'.";
		assert valueCollectionLabel != null
				: "fx:id=\"valueCollectionLabel\" was not injected: check your FXML file 'TabPaneView.fxml'.";

		
		Integer totalBottles = 0;
		// Gsamtanzahl der Flaschen
		for (Wine wine : model.winesList) {

			Integer numOfBottles = wine.getNumberOfBottles();
			totalBottles = totalBottles + numOfBottles;
		}

		String numOfBottlesString = Integer.toString(totalBottles);
		bottleNumLabel.setText(numOfBottlesString);

		Double totalValueColl = 0.00;
		//Gesamtwert der Collection
		for (Wine wine : model.winesList) {

			Double price = wine.getPurchase().getPrice();
			Double totalValueWine = wine.getNumberOfBottles() * price;
			totalValueColl = totalValueColl + totalValueWine;

		}

		String collValueFormat = new DecimalFormat("0.00").format(totalValueColl);
		valueCollectionLabel.setText(collValueFormat + " " + "Euro");

	}

}
