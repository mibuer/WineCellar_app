package at.miriam.wifiproject.mywinecollection;

import java.util.Objects;

public class Storage {

	private String name;
	private int shelfNumber;
	
	
	public Storage() {
		
	}
	
	public Storage(String name, int shelfNumber) {
		super();
		this.name = name;
		this.shelfNumber = shelfNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getShelfNumber() {
		return shelfNumber;
	}
	public void setShelfNumber(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(name, shelfNumber);
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
		return Objects.equals(name, other.name) && shelfNumber == other.shelfNumber;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
	
}
