package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Storage;

public interface StorageRepository {

	//einfügen
			long create(Storage storage) throws SQLException;
			
			//lesen
			Optional<Storage> read(long id) throws SQLException;
			
			//alle lesen
			List<Storage> readAll() throws SQLException;
			
			//ändern
			Storage update(Storage storage) throws SQLException;
			
			//löschen
			void delete(Storage storage) throws SQLException;
	
}
