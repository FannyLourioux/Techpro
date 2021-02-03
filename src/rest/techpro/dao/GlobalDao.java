package rest.techpro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import rest.techpro.model.Product;

public abstract class GlobalDao<T extends Product> {
	protected Map<UUID, T> content = new HashMap<>();
	
	public T add(T product) {
		content.put(product.getId(), product);
		return get(product.getId());
	}
	
	public T delete(T product) {
		content.remove(product.getId());
		return get(product.getId());
	}
	
	public T update(T product) {
		content.replace(product.getId(), product);
		return get(product.getId());
	}
	
	public T get(UUID id) {
		return content.get(id);
	}
	
	public Set<T> addAll(List<T> products) {
		return products.stream().map(product -> add(product)).collect(Collectors.toSet());
	}
	
	public Set<T> deleteAll(List<T> products) {
		return products.stream().map(product -> delete(product)).collect(Collectors.toSet());
	}
	
	public Set<T> updateAll(List<T> products) {
		return products.stream().map(product -> update(product)).collect(Collectors.toSet());
	}
	
	public Set<T> getAll() {
		return content.values().stream().collect(Collectors.toSet());
	}
}
