package at.miriam.wifiproject.mywinecollection.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Purchase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPurchase;
	private String wineShop;
	private LocalDate dateOfPurchase;
	private Double price;
	
	
	public Purchase() {
		super();
	}
	
	public Purchase(long idPurchase, String wineShop, LocalDate dateOfPurchase, Double price) {
		super();
		this.idPurchase = idPurchase;
		this.wineShop = wineShop;
		this.dateOfPurchase = dateOfPurchase;
		this.price = price;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public long getIdPurchase() {
		return idPurchase;
	}

	public void setIdPurchase(long idPurchase) {
		this.idPurchase = idPurchase;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfPurchase, idPurchase, price, wineShop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		return Objects.equals(dateOfPurchase, other.dateOfPurchase) && idPurchase == other.idPurchase
				&& Objects.equals(price, other.price) && Objects.equals(wineShop, other.wineShop);
	}

	@Override
	public String toString() {
		return "Purchase [idPurchase=" + idPurchase + ", wineShop=" + wineShop + ", dateOfPurchase=" + dateOfPurchase
				+ ", price=" + price + "]";
	}
	


	
	
	
	
	
}
