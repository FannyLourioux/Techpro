package rest.techpro.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
	CHEAP("cheap");
	
	private final String name;
	private static final Map<String, Category> BY_VALUE = new HashMap<>();
	
	static {
		Arrays.asList(values()).stream().forEach(category -> BY_VALUE.put(category.name, category));
	}
	
	Category(String name) {
		this.name = name; 
	}
	
	@JsonValue
	public String getName() {
		return name;
	}
	
	@JsonCreator
	public Category of(String name) {
		return BY_VALUE.get(name);
	}
}
