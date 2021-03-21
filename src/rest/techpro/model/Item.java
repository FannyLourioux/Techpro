package rest.techpro.model;

import java.util.UUID;

public class Item {
	private UUID id;
	private String name;
	private Brand brand;
	private Category category;
	private String photo;
	private String label;
	private double price;
	
	public Item(String name, Brand brand, Category category, String photo, String label, double price) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.photo = photo;
		this.label = label;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
