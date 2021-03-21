package rest.techpro.dao;

import rest.techpro.model.Brand;
import rest.techpro.model.Category;
import rest.techpro.model.Storage;

public class StorageDao extends GlobalDao<Storage> {
	private static StorageDao instance;
	
	private StorageDao() {
		add(new Storage(Brand.DELL, Category.CLE_USB, "C'est un super test", 0, false));
	}
	
	public static StorageDao getInstance() {
		if(instance == null) {
			instance = new StorageDao();
		}
		return instance;
	}
}