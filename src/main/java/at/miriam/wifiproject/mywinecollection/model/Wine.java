package at.miriam.wifiproject.mywinecollection.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Wine implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum WineCategory {
		
		WEISS ("Weiß"), ROSE ("Rosé"), ROT ("Rot"), SÜSS ("Süß"), SCHAUMWEIN ("Schaumwein"), LIKÖRWEIN ("Likörwein");

		private String name;
		
		WineCategory(String name) {
			this.name = name;
		}
		
		public String toString() {
			return name;
		}
	
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long idWine;
	private String name;
	@ManyToOne
	private Producer producer;
	private String vintage;
	private Double alcohol;
	private Variety variety;
	@ManyToOne
	private WineCategory wineCategory;
	private String wineStyle;
	private String readyToDrink;
	private String imagePath;
	@Lob
	private byte[] imageBytes;
	@ManyToOne
	private Storage storage;
	@ManyToOne
	private Purchase purchase;
	private String wineRatings;
	private String notes;
	
	public Wine() {
		
	}

	

	public Wine(long idWine, String name, Producer producer, String vintage, Double alcohol, Variety variety,
			WineCategory wineCategory, String wineStyle, String readyToDrink, String imagePath, byte[] imageBytes,
			Storage storage, Purchase purchase, String wineRatings, String notes) {
		super();
		this.idWine = idWine;
		this.name = name;
		this.producer = producer;
		this.vintage = vintage;
		this.alcohol = alcohol;
		this.variety = variety;
		this.wineCategory = wineCategory;
		this.wineStyle = wineStyle;
		this.readyToDrink = readyToDrink;
		this.imagePath = imagePath;
		this.imageBytes = imageBytes;
		this.storage = storage;
		this.purchase = purchase;
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

	public String getVintage() {
		return vintage;
	}

	public void setVintage(String vintage) {
		this.vintage = vintage;
	}

	public Double getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(Double alcohol) {
		this.alcohol = alcohol;
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

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
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

	public long getIdWine() {
		return idWine;
	}
	
	public void setIdWine(long idWine) {
		this.idWine = idWine;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imageBytes);
		result = prime * result + Objects.hash(alcohol, idWine, imagePath, name, notes, producer, purchase,
				readyToDrink, storage, variety, vintage, wineCategory, wineRatings, wineStyle);
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
		return Objects.equals(alcohol, other.alcohol) && idWine == other.idWine
				&& Arrays.equals(imageBytes, other.imageBytes) && Objects.equals(imagePath, other.imagePath)
				&& Objects.equals(name, other.name) && Objects.equals(notes, other.notes)
				&& Objects.equals(producer, other.producer) && Objects.equals(purchase, other.purchase)
				&& Objects.equals(readyToDrink, other.readyToDrink) && Objects.equals(storage, other.storage)
				&& Objects.equals(variety, other.variety) && Objects.equals(vintage, other.vintage)
				&& wineCategory == other.wineCategory && Objects.equals(wineRatings, other.wineRatings)
				&& Objects.equals(wineStyle, other.wineStyle);
	}



	public String toString() {
		
		return producer + " " +  name + " " + vintage;
	}
	
	
	
	
	
	
	
	

}
