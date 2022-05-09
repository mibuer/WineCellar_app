package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Producer;

public interface ProducerRepository {

		//einfügen
		void create(Producer producer) throws SQLException;
		
		//lesen
		Optional<Producer> read(long id) throws SQLException;
		
		//alle lesen
		List<Producer> readAll() throws SQLException;
		
		//ändern
		Producer update(Producer wine) throws SQLException;
		
		//löschen
		void delete(Producer producer) throws SQLException;
	
}
