package at.miriam.wifiproject.mywinecollection;

import at.miriam.wifiproject.mywinecollection.Wine.WineCategory;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WineModel {

	
	public static final ObservableList<String> countryList = FXCollections.observableArrayList("AT","DE","CH","ES","FR","IT","PT");
	public static final ObservableList<Variety> varietyList = FXCollections.observableArrayList(new Variety("Blaufränkisch"), new Variety("Chardonnay"), new Variety("Cuvée"), new Variety("Gemischter Satz"), 
																	new Variety("Grüner Veltliner"), new Variety("Riesling"), new Variety("Zweigelt"));
	public static final ObservableList<WineCategory> categoryList = FXCollections.observableArrayList(WineCategory.WEISS, WineCategory.ROSE,
																	WineCategory.ROT, WineCategory.SÜSS, WineCategory.SPARKLING, WineCategory.FORTIFIED);
	public static final ObservableList<Storage> storageList = FXCollections.observableArrayList(new Storage("Keller", 0), new Storage("Klimaschrank", 0));
	public static final ObservableList<String> bottleSizeList = FXCollections.observableArrayList("0,25","0,375","0,75","1,0","1,5","2,0","3,0","6,0");
	public static final ObservableList<Wine> winesList = FXCollections.observableArrayList();
	public static final ObservableList<Wine> favWinesList = FXCollections.observableArrayList();
	

	
	
	
	
	
	
}
