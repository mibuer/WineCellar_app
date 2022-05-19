package at.miriam.wifiproject.mywinecollection.model;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.query.NativeQuery;

import at.miriam.wifiproject.mywinecollection.repository.Repository;
import at.miriam.wifiproject.mywinecollection.repository.WineRepository;
import at.miriam.wifiproject.mywinecollection.repository.WineRepositoryJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ValidateDatabaseValues {
	
	
	private static EntityManager em = Repository.em;
	
	public Producer validateProducer(Producer producer) {
		
		
		final String JPQL_PRODUCER = "SELECT p FROM Producer p WHERE p.name = :nameProd"
				+ " and p.country = :country and p.wineRegion = :wineReg "
				+ " and p.vineyard = :vineyardName";
		
		
		TypedQuery<Producer> query = em.createQuery(JPQL_PRODUCER, Producer.class);
		
		
		query.setParameter("nameProd", producer.getName())
				.setParameter("country", producer.getCountry())
				.setParameter("wineReg", producer.getWineRegion())
				.setParameter("vineyardName", producer.getVineyard());
				
		if (!query.getResultList().isEmpty()) { 
			System.out.println(query.getResultList());
			System.out.println("Value found: " + producer.getIdProducer());
			
			return query.getSingleResult();
		}
		
		return null;
	}
	
	
	public Variety validateVariety (Variety variety) {
		
		
		final String JPQL_VARIETY = "SELECT v FROM Variety v WHERE v.name = :name";
		
		
		TypedQuery<Variety> query = em.createQuery(JPQL_VARIETY, Variety.class);
		
		query.setParameter("name", variety.getName());
		
		if(!query.getResultList().isEmpty()) {
			System.out.println("Value found: " + variety.getName());
			return query.getSingleResult();
		}
		
		return null;
		

	}

	public Storage validateStorage (Storage storage) {
		
		
		final String JPQL_STORAGE = "SELECT s FROM Storage s WHERE s.name = :name";
		
		
		TypedQuery<Storage> query = em.createQuery(JPQL_STORAGE, Storage.class);
	
		query.setParameter("name", storage.getName());
		
		if (!query.getResultList().isEmpty()) {
			System.out.println("Value found: " + storage.getName());
			return query.getSingleResult();
		}
		
		return null;	
	}
	
	
	public Purchase validatePurchase (Purchase purchase) {
		
		
		final String JPQL_PURCHASE = "SELECT p FROM Purchase p WHERE p.wineShop = :wineShop and p.dateOfPurchase = :date";
		
		
		TypedQuery<Purchase> query = em.createQuery(JPQL_PURCHASE, Purchase.class);
		
		query.setParameter("wineShop", purchase.getWineShop())
				.setParameter("date", purchase.getDateOfPurchase());
		
		if(!query.getResultList().isEmpty()) {
			System.out.println("Value found: " + purchase.getIdPurchase());
			return query.getSingleResult();
		}
		
		return null;	
	}

}
