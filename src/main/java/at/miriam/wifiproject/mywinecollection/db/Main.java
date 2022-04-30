package at.miriam.wifiproject.mywinecollection.db;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;

import at.miriam.wifiproject.mywinecollection.controller.BaseController;
import at.miriam.wifiproject.mywinecollection.model.Producer;
import at.miriam.wifiproject.mywinecollection.model.Purchase;
import at.miriam.wifiproject.mywinecollection.model.Storage;
import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import at.miriam.wifiproject.mywinecollection.model.WineCategory;
import at.miriam.wifiproject.mywinecollection.repository.ProducerRepository;
import at.miriam.wifiproject.mywinecollection.repository.ProducerRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.PurchaseRepository;
import at.miriam.wifiproject.mywinecollection.repository.PurchaseRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.StorageRepository;
import at.miriam.wifiproject.mywinecollection.repository.StorageRepositoryJPA;
import at.miriam.wifiproject.mywinecollection.repository.WineRepository;
import at.miriam.wifiproject.mywinecollection.repository.WineRepositoryJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		
		dropAndCreateTables();
		
		
		StorageRepositoryJPA.setupDatabaseConnection();
		PurchaseRepositoryJPA.setupDatabaseConnection();
		ProducerRepositoryJPA.setupDatabaseConnection();
		WineRepositoryJPA.setupDatabaseConnection();
		
		testDatabase();
		
	}
	
	
	
	

	private static void testDatabase() throws IOException, SQLException {
		
		
		ProducerRepository producerRepository = new ProducerRepositoryJPA();
		StorageRepository storageRepository = new StorageRepositoryJPA();
		PurchaseRepository purchaseRepository = new PurchaseRepositoryJPA();
		WineRepository wineRepository = new WineRepositoryJPA();
		
		//Test Daten
		Producer producer1 = new Producer(0, "Stift Klosterneuburg", "AT", "Wien", "Nussberg");
		Variety variety1 = new Variety(0, "Gemischter Satz");
		Purchase purchase1 = new Purchase(0, "Vinothek", LocalDate.of(2022, 3, 15), 9.80);
		Storage storage1 = new Storage(0, "Keller 1");
		
		Producer producer2 = new Producer(0, "Pia Strehn", "AT", "Mittelburgenland", "Deutschkreutz");
		Variety variety2 = new Variety(0, "Cuvée");
		Purchase purchase2 = new Purchase(0, "Wein&Co", LocalDate.of(2022, 4, 22), 12.50);
		Storage storage2 = new Storage(0, "Kühlschrank");
		
		Wine wine1 = createWine1(producer1, variety1, purchase1, storage1);
		
		Wine wine2 =  createWine2(producer2, variety2, purchase2, storage2);
		
		//Beispiel Datensätze einfügen 
		//CREATE
		//wine1	
		producerRepository.create(producer1);
		storageRepository.create(storage1);
		purchaseRepository.create(purchase1);
		wineRepository.create(wine1);
		//wine2
		producerRepository.create(producer2);
		storageRepository.create(storage2);
		purchaseRepository.create(purchase2);
		wineRepository.create(wine2);
		
	
		System.out.println(producerRepository.readAll());
		System.out.println(storageRepository.readAll());
		System.out.println(purchaseRepository.readAll());
		System.out.println(wineRepository.readAll());
		
		
		System.out.println(wineRepository.read(wine1.getIdWine()));
		
		
		//UPDATE
		wine1.setName("Grüner Veltliner Klassik");
		wineRepository.update(wine1);
		
		//DELETE
		wineRepository.delete(wine2);
		
	}





	private static Wine createWine2(Producer producer, Variety variety, Purchase purchase, Storage storage) throws IOException {
		
		InputStream is = Main.class.getResourceAsStream("/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		
		Path path = Path.of("src/main/resources/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		String pathString = path.toAbsolutePath().normalize().toString();
		System.out.println(pathString);
		
		return new Wine (0, "Rosé Piaristisch", producer, "2021", 12.5, variety, WineCategory.ROSE, 
					"leicht, fruchtig", "2023", pathString, is.readAllBytes(), storage, 2, 3, "0,75", purchase, "falstaff 90", "bester Rosé"); 
		
	}





	private static Wine createWine1(Producer producer, Variety variety, Purchase purchase, Storage storage) throws IOException {
		
		InputStream is = Main.class.getResourceAsStream("/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		
		Path path = Path.of("src/main/resources/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		String pathString = path.toAbsolutePath().normalize().toString();
		System.out.println(pathString);
		
		return new Wine (0, "Wiener Gemischter Satz DAC", producer, "2021", 12.5, variety, WineCategory.WEISS, 
					"leicht, fruchtig", "2023", pathString, is.readAllBytes(), storage, 1, 6, "0,75", purchase, "falstaff 93", "Geburtstagsparty"); 
		
	}













	private static void dropAndCreateTables() {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		EntityManager em = emf.createEntityManager();
		
		em.close();
		emf.close();
	}

}
