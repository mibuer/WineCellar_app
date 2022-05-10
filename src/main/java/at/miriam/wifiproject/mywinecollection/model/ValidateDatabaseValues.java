package at.miriam.wifiproject.mywinecollection.model;

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
	
//	public boolean validateWine (Wine wine) {
//		
//		
//		
//		
//	}
	
	
	
	
	public boolean validateProducer(Producer name) {
		
		TypedQuery<Producer> query = em.createQuery("SELECT p FROM Producer p WHERE p.name :name", Producer.class);
		
		if (query.getResultList() != null) {
			System.out.println("Value found");
			return true;
		} 
		
		return false;
	}
	
	
	public boolean validateVariety (Variety variety) {
		
		TypedQuery<Variety> query = em.createQuery("SELECT v FROM Variety WHERE v.name :name", Variety.class);
		
		if (query.getResultList() != null) {
			System.out.println("Value found");
			return true;
		} 
	
		return false;	
	}

	public boolean validateStorage (Storage storage) {
		
		TypedQuery<Storage> query = em.createQuery("SELECT s FROM Storage WHERE s.name :name", Storage.class);
		
		if (query.getResultList() != null) {
			System.out.println("Value found");
			return true;
		} 
	
		return false;	
	}
	
	public boolean validatePurchase (Purchase purchase) {
		
		TypedQuery<Storage> query = em.createQuery("SELECT p FROM Purchase WHERE p.wineShop :wineShop", Storage.class);
		
		if (query.getResultList() != null) {
			System.out.println("Value found");
			return true;
		} 
	
		return false;	
	}

}
