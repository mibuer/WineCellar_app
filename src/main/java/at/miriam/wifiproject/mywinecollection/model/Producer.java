package at.miriam.wifiproject.mywinecollection.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery (name = "producerQuery", query = "select p FROM Producer p")
public class Producer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProducer;
	private String name;
	private String country;
	private String wineRegion;
	private String vineyard;
	
	public Producer() {
		
	}
	
	

	public Producer(long idProducer, String name, String country, String wineRegion, String vineyard) {
		super();
		this.idProducer = idProducer;
		this.name = name;
		this.country = country;
		this.wineRegion = wineRegion;
		this.vineyard = vineyard;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWineRegion() {
		return wineRegion;
	}

	public void setWineRegion(String wineRegion) {
		this.wineRegion = wineRegion;
	}

	public String getVineyard() {
		return vineyard;
	}

	public void setVineyard(String vineyard) {
		this.vineyard = vineyard;
	}


	
	public long getIdProducer() {
		return idProducer;
	}



	public void setIdProducer(long idProducer) {
		this.idProducer = idProducer;
	}



	@Override
	public int hashCode() {
		return Objects.hash(country, idProducer, name, vineyard, wineRegion);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producer other = (Producer) obj;
		return Objects.equals(country, other.country) && idProducer == other.idProducer
				&& Objects.equals(name, other.name) && Objects.equals(vineyard, other.vineyard)
				&& Objects.equals(wineRegion, other.wineRegion);
	}



	@Override
	public String toString() {
		return name;
	}
	
	
	
}
