package mywinecollection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import at.miriam.wifiproject.mywinecollection.model.Producer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TestDatabaseValidation {

	private static EntityManager em;

	@BeforeAll
	public static void setupDatabaseConnection() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WineDB");
		em = emf.createEntityManager();
	}

	@Test
	public boolean validateProducer(Producer producer) {

		setupDatabaseConnection();

		TypedQuery<Producer> query = em.createQuery("SELECT p FROM Producer p WHERE p.nameProducer = :name",
				Producer.class);

		String nameProducer = producer.getName();

		Producer producerResult = query.setParameter("name", nameProducer).getSingleResult();

		if (producerResult.equals(producer)) {
			System.out.println(producerResult + " " + producer);
			return true;
		}

		return false;

	}

}
