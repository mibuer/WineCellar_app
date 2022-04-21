package at.miriam.wifiproject.mywinecollection.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import at.miriam.wifiproject.mywinecollection.model.Purchase;

public interface PurchaseRepository {

	
			//einfügen
			long create(Purchase purchase) throws SQLException;
			
			//lesen
			Optional<Purchase> read(long id) throws SQLException;
			
			//alle lesen
			List<Purchase> readAll() throws SQLException;
			
			//ändern
			Purchase update(Purchase purchase) throws SQLException;
			
			//löschen
			void delete(Purchase purchase) throws SQLException;
}
