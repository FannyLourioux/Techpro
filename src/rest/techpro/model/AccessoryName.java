package rest.techpro.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AccessoryName {
	Case("case");
	
	private final String name;
	private static final Map<String, AccessoryName> BY_VALUE = new HashMap<>();
	
	static {
		Arrays.asList(values()).stream().forEach(accessory -> BY_VALUE.put(accessory.name, accessory));
	}
	
	AccessoryName(String name) {
		this.name = name; 
	}
	
	@JsonValue
	public String getName() {
		return name;
	}
	
	@JsonCreator
	public AccessoryName of(String name) {
		return BY_VALUE.get(name);
	}
}
