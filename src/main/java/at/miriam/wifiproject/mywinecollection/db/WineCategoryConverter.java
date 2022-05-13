package at.miriam.wifiproject.mywinecollection.db;

import java.util.stream.Stream;

import at.miriam.wifiproject.mywinecollection.model.WineCategory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter (autoApply = true)
public class WineCategoryConverter implements AttributeConverter<WineCategory, String> {

	@Override
	public String convertToDatabaseColumn (WineCategory wineCategory) {
		if (wineCategory == null) {
			return null;
		}
		return wineCategory.getCode();
		
	}

	@Override
	public WineCategory convertToEntityAttribute(String code) {
		
		if(code == null) {
			return null;
		}
		return Stream.of(WineCategory.values())
				.filter(c -> c.getCode().equals(code))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
	
}
