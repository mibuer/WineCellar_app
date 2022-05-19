package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public interface Repository<T> {

	public static EntityManager em = setupDatabaseConnection();

	public static EntityManager setupDatabaseConnection() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		return emf.createEntityManager();
	}
	
	void create(T entity) throws SQLException;
	
	//lesen
	Optional<T> read(long id) throws SQLException;
	
	//alle lesen
	List<T> readAll() throws SQLException;
	
	//ändern
	T update(T entity) throws SQLException;
	
	//löschen
	void delete(T entity) throws SQLException;
	

}
