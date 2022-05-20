package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Storage;

public interface StorageRepository extends Repository<Storage> {

	//einfügen
			void create(Storage storage) throws SQLException;
			
			//lesen
			Optional<Storage> read(long id) throws SQLException;
			
			//alle lesen
			List<Storage> readAll() throws SQLException;
			
			//ändern
			Storage update(Storage storage) throws SQLException;
			
			//löschen
			void delete(Storage storage) throws SQLException;
			
			void deleteAll() throws SQLException;
	
}
