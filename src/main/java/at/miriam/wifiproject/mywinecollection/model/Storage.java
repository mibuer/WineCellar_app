package at.miriam.wifiproject.mywinecollection.model;

import java.util.Objects;

public class Storage {

	private String name;
	private Integer shelfNumber;
	private Integer numberOfBottles;
	private String bottleSize;

	public Storage() {
		
	}

	public Storage(String name, Integer shelfNumber, Integer numberOfBottles, String bottleSize) {
		super();
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

	public Integer getBottleNumber() {
		return numberOfBottles;
	}

	public void setBottleNumber(Integer bottleNumber) {
		this.numberOfBottles = bottleNumber;
	}

	public String getBottleSize() {
		return bottleSize;
	}

	public void setBottleSize(String bottleSize) {
		this.bottleSize = bottleSize;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberOfBottles, bottleSize, name, shelfNumber);
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
		return Objects.equals(numberOfBottles, other.numberOfBottles) && Objects.equals(bottleSize, other.bottleSize)
				&& Objects.equals(name, other.name) && Objects.equals(shelfNumber, other.shelfNumber);
	}

	@Override
	public String toString() {
		return "Storage [name=" + name + ", shelfNumber=" + shelfNumber + ", bottleNumber=" + numberOfBottles
				+ ", bottleSize=" + bottleSize + "]";
	}
	
	
	
	
}
