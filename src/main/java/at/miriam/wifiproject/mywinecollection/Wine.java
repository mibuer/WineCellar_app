package at.miriam.wifiproject.mywinecollection;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Wine {
	
	enum WineCategory {
		WEISS, ROSE, ROT, SÜSS, SPARKLING, FORTIFIED
	}

	private String name;
	private Producer producer;
	private String country;
	private String vintage;
	private String alcohol;
	private String wineRegion;
	private String vineyard;
	private Variety variety;
	private WineCategory wineCategory;
	private String wineStyle;
	private String readyToDrink;
	private String imagePath;
	private byte[] imageBytes;
	private Storage storageLocation;
	private String shelfNumber;
	private String bottleNumber;
	private String bottleSize;
	private String wineShop;
	private LocalDate dateOfPurchase;
	private String price;
	private String wineRatings;
	private String notes;
	
	public Wine() {
		
	}

	public Wine(String name, Producer producer, String country, String vintage, String alcohol, String wineRegion,
			String vineyard, Variety variety, WineCategory wineCategory, String wineStyle, String readyToDrink,
			String imagePath, byte[] imageBytes, Storage storageLocation, String shelfNumber, String bottleNumber,
			String bottleSize, String wineShop, LocalDate dateOfPurchase, String price, String wineRatings,
			String notes) {
		super();
		this.name = name;
		this.producer = producer;
		this.country = country;
		this.vintage = vintage;
		this.alcohol = alcohol;
		this.wineRegion = wineRegion;
		this.vineyard = vineyard;
		this.variety = variety;
		this.wineCategory = wineCategory;
		this.wineStyle = wineStyle;
		this.readyToDrink = readyToDrink;
		this.imagePath = imagePath;
		this.imageBytes = imageBytes;
		this.storageLocation = storageLocation;
		this.shelfNumber = shelfNumber;
		this.bottleNumber = bottleNumber;
		this.bottleSize = bottleSize;
		this.wineShop = wineShop;
		this.dateOfPurchase = dateOfPurchase;
		this.price = price;
		this.wineRatings = wineRatings;
		this.notes = notes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVintage() {
		return vintage;
	}

	public void setVintage(String vintage) {
		this.vintage = vintage;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
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

	public Variety getVariety() {
		return variety;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}

	public WineCategory getWineCategory() {
		return wineCategory;
	}

	public void setWineCategory(WineCategory wineCategory) {
		this.wineCategory = wineCategory;
	}

	public String getWineStyle() {
		return wineStyle;
	}

	public void setWineStyle(String wineStyle) {
		this.wineStyle = wineStyle;
	}

	public String getReadyToDrink() {
		return readyToDrink;
	}

	public void setReadyToDrink(String readyToDrink) {
		this.readyToDrink = readyToDrink;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public byte[] getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}

	public Storage getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(Storage storageLocation) {
		this.storageLocation = storageLocation;
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

	public String getWineShop() {
		return wineShop;
	}

	public void setWineShop(String wineShop) {
		this.wineShop = wineShop;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWineRatings() {
		return wineRatings;
	}

	public void setWineRatings(String wineRatings) {
		this.wineRatings = wineRatings;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imageBytes);
		result = prime * result + Objects.hash(alcohol, bottleNumber, bottleSize, country, dateOfPurchase, imagePath,
				name, notes, price, producer, readyToDrink, shelfNumber, storageLocation, variety, vineyard, vintage,
				wineCategory, wineRatings, wineRegion, wineShop, wineStyle);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wine other = (Wine) obj;
		return Objects.equals(alcohol, other.alcohol) && Objects.equals(bottleNumber, other.bottleNumber)
				&& Objects.equals(bottleSize, other.bottleSize) && Objects.equals(country, other.country)
				&& Objects.equals(dateOfPurchase, other.dateOfPurchase) && Arrays.equals(imageBytes, other.imageBytes)
				&& Objects.equals(imagePath, other.imagePath) && Objects.equals(name, other.name)
				&& Objects.equals(notes, other.notes) && Objects.equals(price, other.price)
				&& Objects.equals(producer, other.producer) && Objects.equals(readyToDrink, other.readyToDrink)
				&& Objects.equals(shelfNumber, other.shelfNumber)
				&& Objects.equals(storageLocation, other.storageLocation) && Objects.equals(variety, other.variety)
				&& Objects.equals(vineyard, other.vineyard) && Objects.equals(vintage, other.vintage)
				&& wineCategory == other.wineCategory && Objects.equals(wineRatings, other.wineRatings)
				&& Objects.equals(wineRegion, other.wineRegion) && Objects.equals(wineShop, other.wineShop)
				&& Objects.equals(wineStyle, other.wineStyle);
	}

	@Override
	public String toString() {
		return "Wine [name=" + name + ", producer=" + producer + ", country=" + country + ", vintage=" + vintage
				+ ", alcohol=" + alcohol + ", wineRegion=" + wineRegion + ", vineyard=" + vineyard + ", variety="
				+ variety + ", wineCategory=" + wineCategory + ", wineStyle=" + wineStyle + ", readyToDrink="
				+ readyToDrink + ", imagePath=" + imagePath + ", imageBytes=" + Arrays.toString(imageBytes)
				+ ", storageLocation=" + storageLocation + ", shelfNumber=" + shelfNumber + ", bottleNumber="
				+ bottleNumber + ", bottleSize=" + bottleSize + ", wineShop=" + wineShop + ", dateOfPurchase="
				+ dateOfPurchase + ", price=" + price + ", wineRatings=" + wineRatings + ", notes=" + notes + "]";
	}

	
	
	
	

}
