package at.miriam.wifiproject.mywinecollection;

import java.util.Objects;

public class Variety {

	private String name;

	public Variety(String name) {
		super();
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

	@Override
	public int hashCode() {
		return Objects.hash(name);
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
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
}
