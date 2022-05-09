package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Wine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class WineRepositoryJPA implements WineRepository {

	private static EntityManager em;
	
	public static void setupDatabaseConnection() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		em = emf.createEntityManager();
	}

	@Override
	public void create(Wine wine) throws SQLException { 
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(wine);
		
		transaction.commit();
		
	}

	@Override
	public Optional<Wine> read(long id) throws SQLException { //find wine with specific id
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Wine wine = em.find(Wine.class, id);
		
		transaction.commit();
		
		return Optional.ofNullable(wine);
	}

	@Override
	public List<Wine> readAll() throws SQLException { //find all Wines  
		
		TypedQuery<Wine> query = em.createQuery("SELECT w FROM Wine w", Wine.class);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Wine> wines = query.getResultList();
		
		transaction.commit();
		
		return wines;
	}

	@Override
	public Wine update(Wine wine) throws SQLException { 
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Wine updatedWine = em.merge(wine);
		
		transaction.commit();
		
		return updatedWine;
	
	}

	@Override
	public void delete(Wine wine) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.remove(wine);
		
		transaction.commit();
		
	}

	@Override
	public List<Wine> findByName(String name) throws SQLException {
		
		TypedQuery<Wine> query = em.createQuery("SELECT w FROM Wine WHERE w.name = :name", Wine.class);
		query.setParameter("name", name);
		
		return query.getResultList();
	}
	
}
