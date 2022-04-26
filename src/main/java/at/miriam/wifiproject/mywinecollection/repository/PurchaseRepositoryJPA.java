package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Purchase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PurchaseRepositoryJPA implements PurchaseRepository {

	private static EntityManager em;
	
	public static void setupDatabaseConnection() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		em = emf.createEntityManager();
	}
	
	
	@Override
	public long create(Purchase purchase) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(purchase);
		
		transaction.commit();
		
		
		return 0;
	}

	@Override
	public Optional<Purchase> read(long id) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Purchase purchase = em.find(Purchase.class, id);
		
		transaction.commit();
		
		return Optional.ofNullable(purchase);
	}

	@Override
	public List<Purchase> readAll() throws SQLException {
		
		TypedQuery<Purchase> query = em.createQuery("SELECT p FROM Purchase p", Purchase.class);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Purchase> purchases = query.getResultList();
		
		transaction.commit();
		
		return purchases;
	}

	@Override
	public Purchase update(Purchase purchase) throws SQLException {
	
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Purchase updatedPurchase = em.merge(purchase);
		
		transaction.commit();
		
		return updatedPurchase;
	
	}

	@Override
	public void delete(Purchase purchase) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.remove(purchase);
		
		transaction.commit();
		
	}

}
