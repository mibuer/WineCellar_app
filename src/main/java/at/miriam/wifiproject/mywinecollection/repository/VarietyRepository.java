package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


import at.miriam.wifiproject.mywinecollection.model.Variety;

public interface VarietyRepository {
	
	//einfügen
	long create(Variety variety) throws SQLException;
	
	//lesen
	Optional<Variety> read(long id) throws SQLException;
	
	//alle lesen
	List<Variety> readAll() throws SQLException;
	
	//ändern
	Variety update(Variety variety) throws SQLException;
	
	//löschen
	void delete(Variety variety) throws SQLException;
	
}
