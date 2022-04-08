package at.miriam.wifiproject.mywinecollection;

import java.util.Objects;

public class Producer {

	private String name;
	private String country;
	private String wineRegion;
	private String vineyard;
	
	public Producer() {
		
	}
	
	public Producer(String name, String country, String wineRegion, String vineyard) {
		super();
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


	@Override
	public int hashCode() {
		return Objects.hash(country, name, vineyard, wineRegion);
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
		return Objects.equals(country, other.country) && Objects.equals(name, other.name)
				&& Objects.equals(vineyard, other.vineyard) && Objects.equals(wineRegion, other.wineRegion);
	}

	@Override
	public String toString() {
		return "Producer [name=" + name + ", country=" + country + ", wineRegion=" + wineRegion + ", vineyard="
				+ vineyard + "]";
	}
	
	
	
}
