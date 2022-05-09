package at.miriam.wifiproject.mywinecollection.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQuery (name = "varietyQuery", query = "SELECT v FROM Variety v")
public class Variety implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idVariety;
	private String name;
	@OneToMany (mappedBy = "variety")
	private List<Wine> varietyWines = new ArrayList<>();
 

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

	
	
	public List<Wine> getVarietyWines() {
		return varietyWines;
	}

	public void setVarietyWines(List<Wine> varietyWines) {
		this.varietyWines = varietyWines;
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
		return  name;
	}

	
	
	
}
