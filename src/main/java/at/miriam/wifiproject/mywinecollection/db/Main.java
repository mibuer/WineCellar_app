package at.miriam.wifiproject.mywinecollection.db;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import at.miriam.wifiproject.mywinecollection.model.Producer;
import at.miriam.wifiproject.mywinecollection.model.Purchase;
import at.miriam.wifiproject.mywinecollection.model.Storage;
import at.miriam.wifiproject.mywinecollection.model.ValidateDatabaseValues;
import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import at.miriam.wifiproject.mywinecollection.model.WineCategory;
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
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main {

	static ProducerRepository producerRepository = new ProducerRepositoryJPA();
	static StorageRepository storageRepository = new StorageRepositoryJPA();
	static PurchaseRepository purchaseRepository = new PurchaseRepositoryJPA();
	static WineRepository wineRepository = new WineRepositoryJPA();
	static VarietyRepository varietyRepository = new VarietyRepositoryJPA();

	static ValidateDatabaseValues validator = new ValidateDatabaseValues();
	
	
	public static void main(String[] args) throws IOException, SQLException {
		
//		dropAndCreateTables();
//		
//		
//		StorageRepositoryJPA.setupDatabaseConnection();
//		PurchaseRepositoryJPA.setupDatabaseConnection();
//		ProducerRepositoryJPA.setupDatabaseConnection();
//		WineRepositoryJPA.setupDatabaseConnection();
		
		testDatabase();
	}
	
	
	private static void testDatabase() throws IOException, SQLException {
		
		
		//Test Daten
		Producer producer1 = new Producer(0, "Stift Klosterneuburg", "AT", "Thermenregion", "Tattendorf");
		Variety variety1 = new Variety(0, "Cuvée");
		Purchase purchase1 = new Purchase(0, "Vinothek", LocalDate.of(2022, 3, 16), 10.90);
		Storage storage1 = new Storage(0, "Keller");
		
		
		Producer producer2 = new Producer(0, "Pia Strehn", "AT", "Mittelburgenland", "Deutschkreutz");
		Variety variety2 = new Variety(0, "Blaufränkisch");
		Purchase purchase2 = new Purchase(0, "Lobenberg", LocalDate.of(2022, 4, 22), 12.50);
		Storage storage2 = new Storage(0, "Keller");
		
		Wine wine1 = createWine1(producer1, variety1, purchase1, storage1);
		
		Wine wine2 =  createWine2(producer2, variety2, purchase2, storage2);
		
		System.out.println("******************** TEST Daten ******************************************************");
		System.out.println(wine1 + " " + wine2);
		
		//Beispiel Datensätze einfügen 
		//CREATE
		
		System.out.println("*****************************Starting DB Test validate ******************************");
		
		validate(producer1, variety1, purchase1, storage1, wine1);
		validate(producer2, variety2, purchase2, storage2, wine2);
		
		System.out.println("**************************Create Wines **********************************************");
		
		wineRepository.create(wine1);
		wineRepository.create(wine2);
		
		System.out.println("**************************Read Repositories: ****************************************");
	
		System.out.println("Producers: " +  producerRepository.readAll());
		System.out.println("Storage: " + storageRepository.readAll());
		System.out.println("Purchase: " + purchaseRepository.readAll());
		System.out.println("Wines: " + wineRepository.readAll());
		
		System.out.println("******************************** READ Wine1 and Wine2 *******************************");
		
		System.out.println(wineRepository.read(wine1.getIdWine()));
		
		System.out.println(wineRepository.read(wine2.getIdWine()));
		
		//UPDATE
		System.out.println("********************* UPDATE ************************************************************");
		
		wine1.setName("Grüner Veltliner Klassik");
		wineRepository.update(wine1);
		System.out.println(wine1);
		
		// UPDATE: put in another storage
		wine2.setStorage(storage1);
		
		//DELETE
		System.out.println("******************************* DELETE *************************************************");
		wineRepository.delete(wine2);
		
		
		System.out.println(wineRepository.readAll());
		
		
	}
	
	
	
	private static void validate(Producer producer1, Variety variety1, Purchase purchase1, 
									Storage storage1, Wine wine1) throws SQLException {
		
		Storage existingStorage;
		if ((existingStorage = validator.validateStorage(storage1)) != null) {
			wine1.setStorage(existingStorage);
		} else {
			storageRepository.create(storage1);
		}
		
		Purchase existingPurchase;
		if ((existingPurchase = validator.validatePurchase(purchase1)) != null) {
			wine1.setPurchase(existingPurchase);
		} else {
			purchaseRepository.create(purchase1);
			System.err.println("Created purchase: " + purchase1.getIdPurchase());
		}
		
		Variety existingVariety;
		if ((existingVariety = validator.validateVariety(variety1)) != null) {
			wine1.setVariety(existingVariety);
		} else {
			varietyRepository.create(wine1.getVariety());
		}

		Producer producer;
		if ((producer = validator.validateProducer(producer1)) != null) {
			wine1.setProducer(producer);
		} else {
			
			producerRepository.create(producer1);
		}
		
	}

	private static Wine createWine2(Producer producer, Variety variety, Purchase purchase, Storage storage) throws IOException {
		
		InputStream is = Main.class.getResourceAsStream("/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		
		Path path = Path.of("src/main/resources/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		String pathString = path.toAbsolutePath().normalize().toString();
		System.out.println(pathString);
		
		return new Wine (0, "Rose", producer, "2021", 12.5, variety, WineCategory.ROSE, 
					"leicht, fruchtig", "2022-23", pathString, is.readAllBytes(), storage, 1, 1, "0,75", purchase, "93 falstaff", "Sommerwein"); 
		
	}


	private static Wine createWine1(Producer producer, Variety variety, Purchase purchase, Storage storage) throws IOException {
		
		InputStream is = Main.class.getResourceAsStream("/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		
		Path path = Path.of("src/main/resources/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		String pathString = path.toAbsolutePath().normalize().toString();
		System.out.println(pathString);
		
		return new Wine (0, "Chorus", producer, "2019", 13.5, variety, WineCategory.ROT, 
					"voll", "2023-28", pathString, is.readAllBytes(), storage, 1, 3, "0,75", purchase, "93 Parker", "Bordeaux-Cuvée"); 
		
	}


	private static void dropAndCreateTables() {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
