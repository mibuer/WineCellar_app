package at.miriam.wifiproject.mywinecollection.model;

import java.util.ArrayList;
import java.util.List;

import at.miriam.wifiproject.mywinecollection.model.Wine.WineCategory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WineModel {

	//Diese Weine werden bei Start des Programms in der Tabelle angezeigt
	public static final List<Wine> initWines = new ArrayList<Wine>();
	
	public final ObservableList<Wine> winesList = FXCollections.observableArrayList(initWines);
	
	public final ObservableList<String> countryList = FXCollections.observableArrayList("AT","DE","CH","ES","FR","IT","PT");
	public final ObservableList<Variety> varietyList = FXCollections.observableArrayList(new Variety(0, "Blaufränkisch"), new Variety(0, "Chardonnay"), new Variety(0, "Cuvée"), new Variety(0, "Mischsatz"), 
																	new Variety(0, "Grüner Veltliner"), new Variety(0, "Riesling"), new Variety(0, "Zweigelt"));
	public final ObservableList<WineCategory> categoryList = FXCollections.observableArrayList(WineCategory.WEISS, WineCategory.ROSE,
																	WineCategory.ROT, WineCategory.SÜSS, WineCategory.SCHAUMWEIN, WineCategory.LIKÖRWEIN);
	public final ObservableList<String> storageList = FXCollections.observableArrayList("Keller","Klimaschrank","Küche");
	public final ObservableList<String> bottleSizeList = FXCollections.observableArrayList("0,25","0,375","0,75","1,0","1,5","2,0","3,0","6,0");
	public final ObservableList<String> wineStylesList = FXCollections.observableArrayList("Aromatisch", "Leicht, trocken","Lieblich","Mittelschwer","Natural", "Orange","Pet Nat","Voll");
 	
	public final ObservableList<Wine> favWinesList = FXCollections.observableArrayList();
	
	//Property: Verbinden von WineTabeleViewController und AddWineViewController
	//WineTableView soll AddWineFormWindow öffnen sobald klick auf Button "Ändern" 
	private final ObjectProperty<Wine> selectedWine = new SimpleObjectProperty<>();

	//returns ObjectProperty from selectedWine
	public final ObjectProperty<Wine> selectedWineProperty() {
		return this.selectedWine;
	}
	//Getter
	public final Wine getSelectedWine() {
		return this.selectedWineProperty().get();
	}
	//Setter
	public final void setSelectedWine(final Wine selectedWine) {
		this.selectedWineProperty().set(selectedWine);
	}
	

	
	
	
	
	
}
