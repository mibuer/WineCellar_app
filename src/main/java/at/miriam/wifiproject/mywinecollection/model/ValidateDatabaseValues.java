package at.miriam.wifiproject.mywinecollection.model;

import org.hibernate.mapping.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ValidateDatabaseValues {
	
private static EntityManager em;
	
	public static void setupDatabaseConnection() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		em = emf.createEntityManager();
	}
	

	
	public boolean validateProducer(Producer producer) {
		
		setupDatabaseConnection();
		
		TypedQuery<Producer> query = em.createQuery("SELECT p FROM Producer p WHERE p.name = name AND p.country = country AND p.wineRegion = wineRegion AND  p.vineyard = vineyard", Producer.class);
		
		if (query.getResultList() != null) {
			System.out.println("Value found");
			return true;
		} 
		
		return false;
	}
	
	
	public boolean validateVariety (Variety variety) {
		
		setupDatabaseConnection();
		
		TypedQuery<Variety> query = em.createQuery("SELECT v FROM Variety v WHERE v.name = name", Variety.class);
		
		if (query.getResultList() != null) {
			System.out.println("Value found");
			return true;
		} 
	
		return false;	
	}

	public boolean validateStorage (Storage storage) {
		
		setupDatabaseConnection();
		
		TypedQuery<Storage> query = em.createQuery("SELECT s FROM Storage s WHERE s.name = name", Storage.class);
		
		if (query.getResultList() != null) {
			System.out.println("Value found");
			return true;
		} 
	
		return false;	
	}
	
	public boolean validatePurchase (Purchase purchase) {
		
		setupDatabaseConnection();
		
		TypedQuery<Purchase> query = em.createQuery("SELECT p FROM Purchase p WHERE p.wineShop = wineShop", Purchase.class);
		
		if (query.getResultList() != null) {
			System.out.println("Value found");
			return true;
		} 
	
		return false;	
	}

}
