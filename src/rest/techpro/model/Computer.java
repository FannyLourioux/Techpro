package rest.techpro.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Computer extends Product {
	private boolean isDesktop;
	
	public Computer(Brand brand, Category category, String label, double price, boolean isDesktop) {
		super(brand, category, label, price);
		this.isDesktop = isDesktop;
	}
	
	public boolean getIsDesktop() {
		return isDesktop;
	}

	public void setDesktop(boolean isDesktop) {
		this.isDesktop = isDesktop;
	}

	@Override
	public String toString() {
		return "Computer [isDesktop=" + isDesktop + ", brand=" + brand + ", category=" + category + ", label=" + label
				+ ", price=" + price + "]";
	}
	
}
