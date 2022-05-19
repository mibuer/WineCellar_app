package mywinecollection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import at.miriam.wifiproject.mywinecollection.db.Main;
import at.miriam.wifiproject.mywinecollection.model.Producer;
import at.miriam.wifiproject.mywinecollection.model.Purchase;
import at.miriam.wifiproject.mywinecollection.model.Storage;
import at.miriam.wifiproject.mywinecollection.model.ValidateDatabaseValues;
import at.miriam.wifiproject.mywinecollection.model.Variety;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import at.miriam.wifiproject.mywinecollection.model.WineCategory;
import at.miriam.wifiproject.mywinecollection.repository.WineRepository;
import at.miriam.wifiproject.mywinecollection.repository.WineRepositoryJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class WineRepositoryTest {
	
	EntityManagerFactory emf;
	
	ValidateDatabaseValues databaseValidation;
	
	@BeforeAll
	public void createDatabaseConnection() {
		
		emf = Persistence.createEntityManagerFactory("WineDB");
	}
	

	@Test
	public void saveWine() throws IOException, SQLException {
		
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
	
		Producer producer1 = new Producer(0, "Stift Klosterneuburg", "AT", "Wien", "Nussberg");
		
//		if (databaseValidation.validateProducer(producer1) == false) {
//		
//		em.persist(producer1);
//		
//		}
		
		Variety variety1 = new Variety(0, "Gemischter Satz");
		
		
		Purchase purchase1 = new Purchase(0, "Vinothek", LocalDate.of(2022, 3, 15), 9.80);
		
		
		Storage storage1 = new Storage(0, "Keller 1");
		
		
		Wine wine1 = createWine1(producer1, variety1, purchase1, storage1);
		
		em.persist(wine1);
	
		em.getTransaction().commit();
		
		em.close();
		
	}
	
	private static Wine createWine1(Producer producer, Variety variety, Purchase purchase, Storage storage) throws IOException {
		
		InputStream is = Main.class.getResourceAsStream("/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		
		Path path = Path.of("src/main/resources/at/miriam/wifiproject/mywinecollection/Images/default_image.png");
		String pathString = path.toAbsolutePath().normalize().toString();
		System.out.println(pathString);
		
		return new Wine (0, "Wiener Gemischter Satz DAC", producer, "2021", 12.5, variety, WineCategory.WEISS, 
					"leicht, fruchtig", "2023", pathString, is.readAllBytes(), storage, 1, 6, "0,75", purchase, "falstaff 93", "Geburtstagsparty"); 
		
	}

}


