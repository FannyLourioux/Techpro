package rest.techpro.resources;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import rest.techpro.dao.AccessoryDao;
import rest.techpro.model.Accessory;

@Path("/accessorys")
public class AccessoryResource {
	private AccessoryDao dao = AccessoryDao.getInstance();
	ObjectMapper mapper = new ObjectMapper();
	
	@Context UriInfo uriInfo;
    @Context Request request;
	
    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Accessory addAccessory(JsonNode node) {
    	Accessory accessory = mapper.convertValue(node, Accessory.class);
		return dao.add(accessory);
	}
    
	// TODO -> Useless to return a deleted accessory
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Accessory deleteAccessory(JsonNode node) {
		Accessory accessory = mapper.convertValue(node, Accessory.class);
		return dao.delete(accessory); 
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Accessory updateAccessory(JsonNode node) {
		Accessory accessory = mapper.convertValue(node, Accessory.class);
		return dao.update(accessory);
	}
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Accessory getAccessory(JsonNode node) {
		UUID id = mapper.convertValue(node, UUID.class);
		return dao.get(id);
	}	*/
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Accessory> addAccessorys(JsonNode node) {
		List<Accessory> accessorys = Arrays.asList(mapper.convertValue(node, Accessory[].class));
		return dao.addAll(accessorys);
	}
	
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Accessory> deleteAccessorys(JsonNode node) {
		List<UUID> ids = Arrays.asList(mapper.convertValue(node, UUID[].class));
		return dao.deleteAll(ids);
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Accessory> updateAccessorys(JsonNode node) {
		List<Accessory> accessorys = Arrays.asList(mapper.convertValue(node, Accessory[].class));
		return dao.updateAll(accessorys);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Accessory> getAccessorys() {
		return dao.getAll();
	}
}
