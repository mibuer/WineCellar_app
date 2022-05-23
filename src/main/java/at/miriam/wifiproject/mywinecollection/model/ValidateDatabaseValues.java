package at.miriam.wifiproject.mywinecollection.model;

import at.miriam.wifiproject.mywinecollection.repository.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ValidateDatabaseValues {
	
	
	private static EntityManager em = Repository.em;
	
	public Producer validateProducer(Producer producer) {
		
		System.out.println("+++++++++++++++++++++++++++ Method validateProducer ++++++++++++++++++++++++++++++++++++");
		
		final String JPQL_PRODUCER = "SELECT p FROM Producer p WHERE p.name = :nameProd"
				+ " and p.country = :country and p.wineRegion = :wineReg "
				+ " and p.vineyard = :vineyardName";
		
		
		TypedQuery<Producer> query = em.createQuery(JPQL_PRODUCER, Producer.class);
		
		
		query.setParameter("nameProd", producer.getName())
				.setParameter("country", producer.getCountry())
				.setParameter("wineReg", producer.getWineRegion())
				.setParameter("vineyardName", producer.getVineyard());
				
		if (!query.getResultList().isEmpty()) { 
			System.out.println("Query Result List: " + query.getResultList());
			System.out.println("Value found: " + producer.toString());
			
			return query.getSingleResult();
		}
		
		return null;
	}
	
	
	public Variety validateVariety (Variety variety) {
		
		System.out.println("+++++++++++++++++++++++++++ Method validateVariety ++++++++++++++++++++++++++++++++++++");
		
		final String JPQL_VARIETY = "SELECT v FROM Variety v WHERE v.name = :name";
		
		
		TypedQuery<Variety> query = em.createQuery(JPQL_VARIETY, Variety.class);
		
		query.setParameter("name", variety.getName());
		
		if(!query.getResultList().isEmpty()) {
			System.out.println("Query Result List: " + query.getResultList());
			System.out.println("Value found: " + variety.getName());
			return query.getSingleResult();
		}
		
		return null;
		

	}

	public Storage validateStorage (Storage storage) {
		
		System.out.println("+++++++++++++++++++++++++++ Method validateStorage ++++++++++++++++++++++++++++++++++++");
		
		final String JPQL_STORAGE = "SELECT s FROM Storage s WHERE s.name = :name";
		
		
		TypedQuery<Storage> query = em.createQuery(JPQL_STORAGE, Storage.class);
	
		query.setParameter("name", storage.getName());
		
		if (!query.getResultList().isEmpty()) {
			System.out.println("Query Result List: " + query.getResultList());
			System.out.println("Value found: " + storage.getName());
			return query.getSingleResult();
		}
		
		return null;	
	}
	
	
	public Purchase validatePurchase (Purchase purchase) {
		
		System.out.println("+++++++++++++++++++++++++++ Method validatePurchase ++++++++++++++++++++++++++++++++++++");
		
		final String JPQL_PURCHASE = "SELECT p FROM Purchase p WHERE p.wineShop = :wineShop and p.dateOfPurchase = :date and p.price = :price";
		
		
		TypedQuery<Purchase> query = em.createQuery(JPQL_PURCHASE, Purchase.class);
		
		query.setParameter("wineShop", purchase.getWineShop())
				.setParameter("date", purchase.getDateOfPurchase())
				.setParameter("price", purchase.getPrice());
		
		if(!query.getResultList().isEmpty()) {
			System.out.println("Query Result List: " + query.getResultList());
			System.out.println("Value found: " + purchase.getIdPurchase());
			return query.getSingleResult();
		}
		
		return null;	
	}

	
	
	
	
}
