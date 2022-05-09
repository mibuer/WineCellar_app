package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


import at.miriam.wifiproject.mywinecollection.model.Variety;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class VarietyRepositoryJPA implements VarietyRepository {

private static EntityManager em;
	
	public static void setupDatabaseConnection() {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		em = emf.createEntityManager();
		
	}
	
	@Override
	public void create(Variety variety) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(variety);
		
		transaction.commit();
		
	}

	@Override
	public Optional<Variety> read(long id) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Variety variety = em.find(Variety.class, id);
		
		transaction.commit();
		
		return Optional.ofNullable(variety);
	}

	@Override
	public List<Variety> readAll() throws SQLException {
		
		TypedQuery<Variety> query = em.createQuery("select v from Variety v", Variety.class);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Variety> varieties = query.getResultList();
		
		transaction.commit();
		
		return varieties;
	}

	@Override
	public Variety update(Variety variety) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Variety updatedVariety = em.merge(variety);
		
		transaction.commit();
		
		return updatedVariety;
	}

	@Override
	public void delete(Variety variety) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.remove(variety);
		
		transaction.commit();
		
	}
	
	

}
