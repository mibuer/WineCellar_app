package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Producer;
import at.miriam.wifiproject.mywinecollection.model.Storage;
import at.miriam.wifiproject.mywinecollection.model.Wine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class StorageRepositoryJPA implements StorageRepository {
	
	@Override
	public void create(Storage storage) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(storage);
		
		transaction.commit();
		
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

	@Override
	public void deleteAll() throws SQLException {
		
		TypedQuery<Storage> query = em.createQuery("select s from Storage s", Storage.class);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Storage> storageToDelete = query.getResultList();
		
		for (Storage storage : storageToDelete) {
			
			em.remove(storage);
			
		}
		
		transaction.commit();
		
		
		
	}

	@Override
	public void deleteWithID(long id) throws SQLException {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Storage storageToDelete = em.find(Storage.class, id);
		
		em.remove(storageToDelete);
		
		transaction.commit();
		
	}

	
}
