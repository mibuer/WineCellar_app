package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Wine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class WineRepositoryJPA implements WineRepository {

	private static EntityManager em;
	
	public static void setupDatabaseConnection() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		em = emf.createEntityManager();
	}

	@Override
	public long create(Wine wine) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Wine> read(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wine> readAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wine update(Wine wine) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Wine wine) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
