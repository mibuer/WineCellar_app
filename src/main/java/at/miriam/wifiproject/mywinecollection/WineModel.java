package at.miriam.wifiproject.mywinecollection;

import at.miriam.wifiproject.mywinecollection.Wine.WineCategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WineModel {

	
	public static final ObservableList<String> countryList = FXCollections.observableArrayList("AT", "DE","ES","FR","PT");
	public static final ObservableList<Variety> varietyList = FXCollections.observableArrayList(new Variety("Grüner Veltliner"), 
																new Variety("Riesling"), new Variety("Zweigelt"));
	public static final ObservableList<WineCategory> categoryList = FXCollections.observableArrayList(WineCategory.WHITE, WineCategory.ROSE,
																	WineCategory.RED, WineCategory.SWEET, WineCategory.SPARKLING, WineCategory.FORTIFIED, WineCategory.CUVÉE);
	public static final ObservableList<Storage> storageList = FXCollections.observableArrayList(new Storage("Keller", 0), new Storage("Klimaschrank", 0));
	public static final ObservableList<String> bottleSizeList = FXCollections.observableArrayList("0,25","0,375","0,75","1,0","1,5","2,0","3,0","6,0");
	public static final ObservableList<Wine> winesList = FXCollections.observableArrayList();
}
