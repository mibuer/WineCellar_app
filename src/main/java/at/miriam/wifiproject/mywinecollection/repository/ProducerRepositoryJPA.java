package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Producer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ProducerRepositoryJPA implements ProducerRepository {

	private static EntityManager em;
	
	public static void setupDatabaseConnection() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		em = emf.createEntityManager();
	}
	
	
	@Override
	public void create(Producer producer) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(producer);
		
		transaction.commit();
		
	}

	@Override
	public Optional<Producer> read(long id) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Producer producer = em.find(Producer.class, id);
		
		transaction.commit();
		
		
		return Optional.ofNullable(producer);
	}

	@Override
	public List<Producer> readAll() throws SQLException {
		
		TypedQuery<Producer> query = em.createQuery("SELECT p FROM Producer p", Producer.class);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Producer> producers = query.getResultList();
		
		transaction.commit();
		
	
		return producers;
	}

	@Override
	public Producer update(Producer producer) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Producer updatedProducer = em.merge(producer);
		
		transaction.commit();
		
		return updatedProducer;
	}

	@Override
	public void delete(Producer producer) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.remove(producer);
		
		transaction.commit();
		
		
	}

}
