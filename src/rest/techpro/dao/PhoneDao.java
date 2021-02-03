package rest.techpro.dao;

import rest.techpro.model.Brand;
import rest.techpro.model.Category;
import rest.techpro.model.Phone;

public class PhoneDao extends GlobalDao<Phone> {
	private static PhoneDao instance;
	
	private PhoneDao() {
		add(new Phone(Brand.DELL, Category.CHEAP, "C'est un super test", 0, false));
	}
	
	public static PhoneDao getInstance() {
		if(instance == null) {
			instance = new PhoneDao();
		}
		return instance;
	}
}