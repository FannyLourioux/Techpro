package rest.techpro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import rest.techpro.model.Brand;
import rest.techpro.model.Category;
import rest.techpro.model.Computer;
import rest.techpro.model.Techpro;


public class ComputerDao2 {
    private static ComputerDao2 instance;
    private Map<String, Computer> contentProvider = new HashMap<>();
    
    public static ComputerDao2 getInstance() {
    	if(instance == null) {
    		instance = new ComputerDao2();
    	}
    	return instance;
    }

    private ComputerDao2() {
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