package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Wine;

public interface WineRepository extends Repository<Wine> {

	//Wein einfügen
	void create(Wine wine) throws SQLException;
	
	//lesen
	Optional<Wine> read(long id) throws SQLException;
	
	//FindByName
	List<Wine> findByName(String name) throws SQLException;
	
	//alle lesen
	List<Wine> readAll() throws SQLException;
	
	//Wein ändern
	Wine update(Wine wine) throws SQLException;
	
	//löschen
	void delete(Wine wine) throws SQLException;
	
	void deleteAll() throws SQLException;
	
	
}
