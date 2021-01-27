package rest.techpro.model;

public class Phone extends Product {
	private boolean isFixed;

	public Phone(Brand brand, Category category, String label, double price, boolean isFixed) {
		super(brand, category, label, price);
		this.isFixed = isFixed;
	}

	public boolean getIsFixed() {
		return isFixed;
	}

	public void setFixed(boolean isFixed) {
		this.isFixed = isFixed;
	}

}
