package rest.techpro.dao;

import rest.techpro.model.Brand;
import rest.techpro.model.Category;
import rest.techpro.model.Computer;

public class ComputerDao extends GlobalDao<Computer> {
	private static ComputerDao instance;
	
	private ComputerDao() {
		add(new Computer(Brand.DELL, Category.CHEAP, "C'est un super test", 0, false));
	}
	
	public static ComputerDao getInstance() {
		if(instance == null) {
			instance = new ComputerDao();
		}
		return instance;
	}
}
