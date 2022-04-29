package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class StorageRepositoryJPA implements StorageRepository {
	
	private static EntityManager em;
	
	
	public static void setupDatabaseConnection() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		em = emf.createEntityManager();
	}
	

	@Override
	public long create(Storage storage) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(storage);
		
		transaction.commit();
		
		
		return 0;
	}

	@Override
	public Optional<Storage> read(long id) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Storage storage = em.find(Storage.class, id);
		
		transaction.commit();
		
		return Optional.ofNullable(storage);
	}

	@Override
	public List<Storage> readAll() throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		TypedQuery<Storage> query = em.createQuery("select s from Storage s", Storage.class);
		List<Storage> storages = query.getResultList();
		
		transaction.commit();
		
		return storages;
	}

	@Override
	public Storage update(Storage storage) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Storage updatedStorage = em.merge(storage);
		
		transaction.commit();
		
		return updatedStorage;
	}

	@Override
	public void delete(Storage storage) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.remove(storage);
		
		transaction.commit();
		
	}

}
