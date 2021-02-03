package rest.techpro.dao;


import rest.techpro.model.Accessory;
import rest.techpro.model.AccessoryName;
import rest.techpro.model.Brand;
import rest.techpro.model.Category;

public class AccessoryDao extends GlobalDao<Accessory> {
	private static AccessoryDao instance;
	
	private AccessoryDao() {
		add(new Accessory(Brand.DELL, Category.CHEAP, "C'est un super test", 0, AccessoryName.Case));
	}
	
	public static AccessoryDao getInstance() {
		if(instance == null) {
			instance = new AccessoryDao();
		}
		return instance;
	}
}