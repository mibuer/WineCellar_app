package at.miriam.wifiproject.mywinecollection.model;

import java.util.Objects;

public class Storage {

	private String name;
	private String shelfNumber;
	private String bottleNumber;
	private String bottleSize;

	public Storage() {
		
	}

	public Storage(String name, String shelfNumber, String bottleNumber, String bottleSize) {
		super();
		this.name = name;
		this.shelfNumber = shelfNumber;
		this.bottleNumber = bottleNumber;
		this.bottleSize = bottleSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShelfNumber() {
		return shelfNumber;
	}

	public void setShelfNumber(String shelfNumber) {
		this.shelfNumber = shelfNumber;
	}

	public String getBottleNumber() {
		return bottleNumber;
	}

	public void setBottleNumber(String bottleNumber) {
		this.bottleNumber = bottleNumber;
	}

	public String getBottleSize() {
		return bottleSize;
	}

	public void setBottleSize(String bottleSize) {
		this.bottleSize = bottleSize;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bottleNumber, bottleSize, name, shelfNumber);
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
		return Objects.equals(bottleNumber, other.bottleNumber) && Objects.equals(bottleSize, other.bottleSize)
				&& Objects.equals(name, other.name) && Objects.equals(shelfNumber, other.shelfNumber);
	}

	@Override
	public String toString() {
		return "Storage [name=" + name + ", shelfNumber=" + shelfNumber + ", bottleNumber=" + bottleNumber
				+ ", bottleSize=" + bottleSize + "]";
	}
	
	
	
	
}
