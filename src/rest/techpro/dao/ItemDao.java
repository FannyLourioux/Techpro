package rest.techpro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.techpro.model.Brand;
import rest.techpro.model.Category;
import rest.techpro.model.Item;


public class ItemDao /*extends GlobalDao<Item> */{
	private Map<UUID, Item> content = new HashMap<>();
	private static ItemDao instance; 
	
	private ItemDao() {
		add(new Item("A", Brand.DELL, Category.PC_FIXE, "xxx", "A famous gaming PC", 2345));
		add(new Item("B", Brand.ASUS, Category.PC_PORTABLE, "xxx", "A famous gaming PC", 1545));
		add(new Item("C", Brand.APPLE, Category.PC_PORTABLE, "xxx", "A pc to edit photos", 5345));
		add(new Item("Z", Brand.APPLE, Category.ACCESSOIRE_PC, "xxx", "A mouse", 110));
		add(new Item("D", Brand.SAN_DISK, Category.CLE_USB, "xxx", "16GB usb stick", 20));
		add(new Item("E", Brand.SAN_DISK, Category.DISQUE_DUR, "xxx", "2TB of storage", 255));
		add(new Item("F", Brand.APPLE, Category.TELEPHONE_PORTABLE, "xxx", "The best of smartphones", 1200));
		add(new Item("Y", Brand.APPLE, Category.ACCESSOIRE_TELEPHONE, "xxx", "The best headphones", 1200));
		
	}
	
	public static ItemDao getInstance() {
		if(instance == null) {
			instance = new ItemDao();
		}
		return instance;
	}
	
	public Item add(Item product) {
		content.put(product.getId(), product);
		return get(product.getId());
	}
	
	public void delete(UUID id) {
		content.remove(id);
	}
	
	public Item update(Item product) {
		content.replace(product.getId(), product);
		return get(product.getId());
	}
	
	public Item get(UUID id) {
		return content.get(id);
	}
	
	public Set<Item> addAll(List<Item> products) {
		return products.stream().map(product -> add(product)).collect(Collectors.toSet());
	}
	
	public Set<Item> deleteAll(List<UUID> products) {
		products.stream().forEach(product -> delete(product));
		return getAll();
	}
	
	public Set<Item> updateAll(List<Item> products) {
		return products.stream().map(product -> update(product)).collect(Collectors.toSet());
	}
	
	public Set<Item> getAll() {
		return content.values().stream().collect(Collectors.toSet());
	}

	public Set<Item> getPcsFixes() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.PC_FIXE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getPcsPortables() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.PC_PORTABLE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getAccessoiresPc() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.ACCESSOIRE_PC)).collect(Collectors.toSet());
	}
	
	public Set<Item> getTelephonesFixes() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.TELEPHONE_FIXE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getTelephonesPortables() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.TELEPHONE_PORTABLE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getAccessoiresTelephone() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.ACCESSOIRE_TELEPHONE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getDisquesDurs() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.DISQUE_DUR)).collect(Collectors.toSet());
	}
	
	public Set<Item> getClesUsb() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.CLE_USB)).collect(Collectors.toSet());
	}
	
	public Set<Item> getAccessoiresStockage() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.ACCESSOIRE_STOCKAGE)).collect(Collectors.toSet());
	}
}
