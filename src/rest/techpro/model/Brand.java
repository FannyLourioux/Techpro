package rest.techpro.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Brand {
	DELL("dell"), APPLE("apple"), SAN_DISK("san_disk"), ASUS("asus");
	
	private final String name;
	private static final Map<String, Brand> BY_VALUE = new HashMap<>();
	
	static {
		Arrays.asList(values()).stream().forEach(brand -> BY_VALUE.put(brand.name, brand));
	}
	
	Brand(String name) {
		this.name = name; 
	}
	
	@JsonValue
	public String getName() {
		return name;
	}
	
	@JsonCreator
	public Brand of(String name) {
		return BY_VALUE.get(name);
	}
}
