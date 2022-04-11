package at.miriam.wifiproject.mywinecollection.model;

import java.time.LocalDate;
import java.util.Objects;

public class Purchase {

	private String wineShop;
	private LocalDate dateOfPurchase;
	private String price;
	
	public Purchase(String wineShop, LocalDate dateOfPurchase, String price) {
		super();
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dateOfPurchase, price, wineShop);
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
		return Objects.equals(dateOfPurchase, other.dateOfPurchase) && Objects.equals(price, other.price)
				&& Objects.equals(wineShop, other.wineShop);
	}
	
	@Override
	public String toString() {
		return "Purchase [wineShop=" + wineShop + ", dateOfPurchase=" + dateOfPurchase + ", price=" + price + "]";
	}
	
	
	
	
	
}
