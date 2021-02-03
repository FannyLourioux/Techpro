package rest.techpro.dao;

import java.util.HashMap;
import java.util.Map;

import rest.techpro.model.Brand;
import rest.techpro.model.Category;
import rest.techpro.model.Computer;
import rest.techpro.model.Techpro;


public class ComputerDao {
    private static ComputerDao instance;
    private Map<String, Computer> contentProvider = new HashMap<>();
    
    public static ComputerDao getInstance() {
    	if(instance == null) {
    		instance = new ComputerDao();
    	}
    	return instance;
    }

    private ComputerDao() {
        contentProvider.put("ABC", new Computer(Brand.DELL, Category.CHEAP, "C'est une super test", 0, false));
        System.out.println(contentProvider);
    }
    
    public Map<String, Computer> getModel(){
    	System.out.println("La");
        return contentProvider;
    }

	@Override
	public String toString() {
		return "ComputerDao [contentProvider=" + contentProvider + "]";
	}
    
    

}