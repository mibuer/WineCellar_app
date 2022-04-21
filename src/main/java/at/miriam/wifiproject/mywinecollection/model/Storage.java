package at.miriam.wifiproject.mywinecollection.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Storage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idStorage;
	private String name;
	private Integer shelfNumber;
	private Integer numberOfBottles;
	private String bottleSize;

	public Storage() {
		
	}

	

	public Storage(long idStorage, String name, Integer shelfNumber, Integer numberOfBottles, String bottleSize) {
		super();
		this.idStorage = idStorage;
		this.name = name;
		this.shelfNumber = shelfNumber;
		this.numberOfBottles = numberOfBottles;
		this.bottleSize = bottleSize;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getShelfNumber() {
		return shelfNumber;
	}

	public void setShelfNumber(Integer shelfNumber) {
		this.shelfNumber = shelfNumber;
	}

	public String getBottleSize() {
		return bottleSize;
	}

	public void setBottleSize(String bottleSize) {
		this.bottleSize = bottleSize;
	}

	public long getIdStorage() {
		return idStorage;
	}

	public void setIdStorage(long idStorage) {
		this.idStorage = idStorage;
	}

	public Integer getNumberOfBottles() {
		return numberOfBottles;
	}

	public void setNumberOfBottles(Integer numberOfBottles) {
		this.numberOfBottles = numberOfBottles;
	}



	@Override
	public int hashCode() {
		return Objects.hash(bottleSize, idStorage, name, numberOfBottles, shelfNumber);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Storage other = (Storage) obj;
		return Objects.equals(bottleSize, other.bottleSize) && idStorage == other.idStorage
				&& Objects.equals(name, other.name) && Objects.equals(numberOfBottles, other.numberOfBottles)
				&& Objects.equals(shelfNumber, other.shelfNumber);
	}



	@Override
	public String toString() {
		return "Storage [idStorage=" + idStorage + ", name=" + name + ", shelfNumber=" + shelfNumber
				+ ", numberOfBottles=" + numberOfBottles + ", bottleSize=" + bottleSize + "]";
	}

	
	
	
	
}
