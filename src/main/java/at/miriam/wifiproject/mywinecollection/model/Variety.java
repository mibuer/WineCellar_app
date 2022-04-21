package at.miriam.wifiproject.mywinecollection.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Variety implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idVariety;
	private String name;


	public Variety(long idVariety, String name) {
		super();
		this.idVariety = idVariety;
		this.name = name;
	}

	public Variety() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIdVariety() {
		return idVariety;
	}

	public void setIdVariety(long idVariety) {
		this.idVariety = idVariety;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVariety, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variety other = (Variety) obj;
		return idVariety == other.idVariety && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Variety [idVariety=" + idVariety + ", name=" + name + "]";
	}

	
	
	
}
