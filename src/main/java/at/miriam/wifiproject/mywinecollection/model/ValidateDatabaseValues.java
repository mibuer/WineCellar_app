package at.miriam.wifiproject.mywinecollection.model;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ValidateDatabaseValues {
	
private static EntityManager em;
	
	public static void setupDatabaseConnection() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		em = emf.createEntityManager();
	}
	

	
	public boolean validateProducer(Producer producer) {
		
		setupDatabaseConnection();
		
		Query query = em.createNativeQuery("SELECT p.name, p.country, p.wineRegion, p.vineyard FROM Producer p");
		
		//TypedQuery<Producer> query = em.createQuery("SELECT p FROM Producer p WHERE p.name = name AND p.country = country AND p.wineRegion = wineRegion", Producer.class);
		
		if (query.getSingleResult() != null) {
			System.out.println("Value found");
		
			return true;
		} 
		
		return false;
	}
	
	
	public boolean validateVariety (Variety variety) {
		
		setupDatabaseConnection();
		
		TypedQuery<Variety> query = em.createQuery("SELECT v FROM Variety v WHERE v.name = name", Variety.class);
		
		if (query.getSingleResult() != null) {
			System.out.println("Value found");
			return true;
		} 
	
		return false;	
	}

	public boolean validateStorage (Storage storage) {
		
		setupDatabaseConnection();
		
		TypedQuery<Storage> query = em.createQuery("SELECT s FROM Storage s WHERE s.name = name", Storage.class);
		
		if (query.getSingleResult() != null) {
			System.out.println("Value found");
			return true;
		} 
	
		return false;	
	}
	
	public boolean validatePurchase (Purchase purchase) {
		
		setupDatabaseConnection();
		
		TypedQuery<Purchase> query = em.createQuery("SELECT p FROM Purchase p WHERE p.wineShop = wineShop", Purchase.class);
		
		if (query.getSingleResult() != null) {
			System.out.println("Value found");
			return true;
		} 
	
		return false;	
	}

}
