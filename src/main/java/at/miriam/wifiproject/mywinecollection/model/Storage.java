package at.miriam.wifiproject.mywinecollection.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery (name = "storageQuery", query = "select s from Storage s")
public class Storage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idStorage;
	private String name;
	
	

	public Storage() {
		super();
	}

	

	public Storage(long idStorage, String name) {
		super();
		this.idStorage = idStorage;
		this.name = name;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public long getIdStorage() {
		return idStorage;
	}

	public void setIdStorage(long idStorage) {
		this.idStorage = idStorage;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idStorage, name);
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
		return idStorage == other.idStorage && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name;
	}

	

	

	
	
	
	
}
