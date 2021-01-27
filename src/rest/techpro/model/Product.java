package rest.techpro.model;

public abstract class Product {
	protected Brand brand;
	protected Category category;
	protected String label;
	protected double price;
	
	public Product(Brand brand, Category category, String label, double price) {
		this.brand = brand;
		this.category = category;
		this.label = label;
		this.price = price;
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
