package at.miriam.wifiproject.mywinecollection.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.repository.ProducerRepository;
import at.miriam.wifiproject.mywinecollection.repository.ProducerRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.PurchaseRepository;
import at.miriam.wifiproject.mywinecollection.repository.PurchaseRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.StorageRepository;
import at.miriam.wifiproject.mywinecollection.repository.StorageRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.VarietyRepository;
import at.miriam.wifiproject.mywinecollection.repository.VarietyRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.WineRepository;
import at.miriam.wifiproject.mywinecollection.repository.WineRepositoryJPA;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

public class WineModel {

	//Diese Weine werden bei Start des Programms in der Tabelle angezeigt
	//public static final List<Wine> initWines = new ArrayList<Wine>();
	
	//Repositories einbinden
	public WineRepository wineRepository = new WineRepositoryJPA();
	private ProducerRepository producerRepository = new ProducerRepositoryJPA();
	private StorageRepository storageRepository = new StorageRepositoryJPA();
	private VarietyRepository varietyRepository = new VarietyRepositoryJPA();
	private PurchaseRepository purchaseRepository = new PurchaseRepositoryJPA();
	
	private ValidateDatabaseValues dataValidation = new ValidateDatabaseValues();
	
	public final ObservableList<Wine> winesList = FXCollections.observableArrayList();
	
	public final ObservableList<Producer> producerList = FXCollections.observableArrayList();
	public final ObservableList<Storage> storageList = FXCollections.observableArrayList(new Storage(0,"Keller"), new Storage (0, "Klimaschrank") , new Storage (0, "Küche"));
	public final ObservableList<Variety> varietyList = FXCollections.observableArrayList(new Variety(0, "Blaufränkisch"), new Variety(0, "Chardonnay"), new Variety(0, "Cuvée"), new Variety(0, "Mischsatz"), 
																	new Variety(0, "Grüner Veltliner"), new Variety(0, "Riesling"), new Variety(0, "Zweigelt"));
	public final ObservableList<Purchase> purchaseList = FXCollections.observableArrayList();
	
	public final ObservableList<WineCategory> categoryList = FXCollections.observableArrayList(WineCategory.WEISS, WineCategory.ROSE,
			WineCategory.ROT, WineCategory.SÜSS, WineCategory.SCHAUMWEIN, WineCategory.LIKÖRWEIN);
	public final ObservableList<String> bottleSizeList = FXCollections.observableArrayList("0,25","0,375","0,75","1,0","1,5","2,0","3,0","6,0");
	public final ObservableList<String> wineStylesList = FXCollections.observableArrayList("Aromatisch", "Leicht, trocken","Lieblich","Mittelschwer","Natural", "Orange","Pet Nat","Voll");
	public final ObservableList<String> countryList = FXCollections.observableArrayList("AT","DE","CH","ES","FR","IT","PT");
	
	public final ObservableList<Wine> favWinesList = FXCollections.observableArrayList();
	//ChangeListener erstellen für die Auswahl der Favoriten
	

	public WineModel() {
		
		//WineModel wird erstellt, alle Wines aus der DB einlesen
		//alle Producer, Storage, Purchase, Variety
		// und der jeweiligen ObservableList übergeben
		try {
			
			producerList.addAll(producerRepository.readAll());
			varietyList.addAll(varietyRepository.readAll());
			storageList.addAll(storageRepository.readAll());
			purchaseList.addAll(purchaseRepository.readAll());
			winesList.addAll(wineRepository.readAll());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		//Producer
		producerList.addListener(new ListChangeListener<Producer>() {

			@Override
			public void onChanged(Change<? extends Producer> c) {
				
				while (c.next()) {
					
					if (c.wasAdded()) {
						for (Producer producer : c.getAddedSubList()) {
							
							try {
								//Prüfen, ob Eintrag bereits vorhanden 
								if (dataValidation.validateProducer(producer) == null) {
									
									producerRepository.create(producer);
								} 
								
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
					
					else if (c.wasReplaced()) {
						for (Producer producer : c.getAddedSubList()) {
							
							try {
								
								if (dataValidation.validateProducer(producer) == null) {
									
									producerRepository.create(producer);
								}
								
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
					
					else if (c.wasRemoved()) {
						for (Producer producer : c.getAddedSubList()) {
							
							try {
								producerRepository.delete(producer);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
		
		//Variety
		varietyList.addListener(new ListChangeListener<Variety>() {

					@Override
					public void onChanged(Change<? extends Variety> c) {
						
						while (c.next()) {
							
							if (c.wasAdded()) {
								for (Variety variety : c.getAddedSubList()) {
									
									try {
										//Prüfen, ob Eintrag bereits vorhanden 
										if (dataValidation.validateVariety(variety) == null) {
											varietyRepository.create(variety);
										} 
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
							}
							
							else if (c.wasReplaced()) {
								for (Variety variety : c.getAddedSubList()) {
									
									try {
										//Prüfen, ob Eintrag bereits vorhanden 
										if (dataValidation.validateVariety(variety) == null) {
											varietyRepository.update(variety);
										}
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
							}
							
							else if (c.wasRemoved()) {
								for (Variety variety : c.getAddedSubList()) {
									
									try {
										varietyRepository.delete(variety);
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				});
			//Storage
			storageList.addListener(new ListChangeListener<Storage>() {

					@Override
					public void onChanged(Change<? extends Storage> c) {
							
						while (c.next()) {
							
							if (c.wasAdded()) {
								for (Storage storage : c.getAddedSubList()) {
									
									try {
										
										//Prüfen, ob Eintrag bereits vorhanden 
										if (dataValidation.validateStorage(storage) == null) {
										
										storageRepository.create(storage);
										
										}
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
							}
							
							else if (c.wasReplaced()) {
								for (Storage storage : c.getAddedSubList()) {
									
									try {
										
										if (dataValidation.validateStorage(storage) == null) {
										
											storageRepository.update(storage);
										}
										
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
							}
							
							else if (c.wasRemoved()) {
								for (Storage storage : c.getAddedSubList()) {
									
									try {
										storageRepository.delete(storage);
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
							}
							
						}
					}
				});	
			
		//Purchase
		purchaseList.addListener(new ListChangeListener<Purchase>() {

				@Override
				public void onChanged(Change<? extends Purchase> c) {
					
					while (c.next()) {
						
						if (c.wasAdded()) {
							for (Purchase purchase : c.getAddedSubList()) {
								
								try {
									
									if (dataValidation.validatePurchase(purchase) == null) {
										
										purchaseRepository.create(purchase);
									
									}
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
						
						else if (c.wasReplaced()) {
							for (Purchase purchase : c.getAddedSubList()) {
								
								try {
									
									if (dataValidation.validatePurchase(purchase) == null) {
									
										purchaseRepository.update(purchase);
									}
									
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
						
						else if (c.wasRemoved()) {
							for (Purchase purchase : c.getAddedSubList()) {
								
								try {
									purchaseRepository.delete(purchase);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
						
					}
					
				}
				
			});
		
		//Wine
		//ChangeListener -> Änderungen der Liste
		//1. ist ein neuer Wein eingetragen worden? 
		//2. wurde ein Wein ersetzt?
		//3. oder entfernt?
		winesList.addListener(new ListChangeListener<Wine>() {

			@Override
			public void onChanged(Change<? extends Wine> c) {
				
				while (c.next()) {
					
					if(c.wasReplaced()) {
						for (Wine wine : c.getAddedSubList()) {
							
							try {
								
								createRelatedEntitiesIfNotExist(wine);
								
								wineRepository.update(wine);
								
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}	
					}
					
					else if (c.wasAdded()) {
						for (Wine wine : c.getAddedSubList()) {
							
							try {
								
								Producer producer = wine.getProducer();
								if (dataValidation.validateProducer(wine.getProducer()) == null) {
									
									wine.setProducer(producer);
									producerRepository.create(producer);
								} 
								
								Variety variety = wine.getVariety();
								if (dataValidation.validateVariety(variety) == null) {
									
									varietyRepository.create(variety);
								} 
								Storage storage = wine.getStorage();
								if (dataValidation.validateStorage(storage) == null) {
									
									storageRepository.create(storage);
								}
								Purchase purchase = wine.getPurchase();
								if (dataValidation.validatePurchase(purchase) == null) {
									
									purchaseRepository.create(purchase);
								}
								
								wineRepository.create(wine);
								
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
					
					else if (c.wasRemoved()) {
						for (Wine wine : c.getRemoved()) {
							
							try {
								wineRepository.delete(wine);
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
		
	} // ---------------------------------------------------------------------
	
	
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
	
	//---------------------------------------------------------------------------------
	
	private void createRelatedEntitiesIfNotExist(Wine wine) throws SQLException {
		
		Storage existingStorage;
		if ((existingStorage = dataValidation.validateStorage(wine.getStorage())) != null) {
			wine.setStorage(existingStorage);
		} else {
			storageRepository.create(wine.getStorage());
		}
		Purchase existingPurchase;
		if ((existingPurchase = dataValidation.validatePurchase(wine.getPurchase())) != null) {
			wine.setPurchase(existingPurchase);
		} else {
			purchaseRepository.create(wine.getPurchase());
		
		}
		Variety existingVariety;
		if ((existingVariety = dataValidation.validateVariety(wine.getVariety())) != null) {
			wine.setVariety(existingVariety);
		} else {
			varietyRepository.create(wine.getVariety());
		}

		Producer existingProducer;
		if ((existingProducer = dataValidation.validateProducer(wine.getProducer())) != null) {
			wine.setProducer(existingProducer);
		} else {
			
			producerRepository.create(wine.getProducer());
		}
	}
	
	
	
	
	
}
