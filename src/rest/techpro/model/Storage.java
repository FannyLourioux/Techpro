package rest.techpro.model;

public class Storage extends Product {
	private boolean isUsb;

	public Storage(Brand brand, Category category, String label, double price, boolean isUsb) {
		super(brand, category, label, price);
		this.isUsb = isUsb;
	}

	public boolean getIsUsb() {
		return isUsb;
	}

	public void setUsb(boolean isUsb) {
		this.isUsb = isUsb;
	}

}
