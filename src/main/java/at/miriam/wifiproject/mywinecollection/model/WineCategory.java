package at.miriam.wifiproject.mywinecollection.model;

public enum WineCategory {

	
	WEISS ("Weiß"), ROSE ("Rosé"), ROT ("Rot"), SÜSS ("Süß"), SCHAUMWEIN ("Schaumwein"), LIKÖRWEIN ("Likörwein");

	private String name;
	
//	WineCategory(String name) {
//		this.name = name;
//	}
	

	public String toString() {
		return name;
		
	}
	
	private String code;
	
	private WineCategory (String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	
	
}
