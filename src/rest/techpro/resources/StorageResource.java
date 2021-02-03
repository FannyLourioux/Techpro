package rest.techpro.resources;

import java.util.Arrays;
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

import rest.techpro.dao.StorageDao;
import rest.techpro.model.Storage;

@Path("/storages")
public class StorageResource {
	private StorageDao dao = StorageDao.getInstance();
	ObjectMapper mapper = new ObjectMapper();
	
	@Context UriInfo uriInfo;
    @Context Request request;
	
    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Storage addStorage(JsonNode node) {
    	Storage storage = mapper.convertValue(node, Storage.class);
		return dao.add(storage);
	}
    
	// TODO -> Useless to return a deleted storage
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Storage deleteStorage(JsonNode node) {
		Storage storage = mapper.convertValue(node, Storage.class);
		return dao.delete(storage); 
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Storage updateStorage(JsonNode node) {
		Storage storage = mapper.convertValue(node, Storage.class);
		return dao.update(storage);
	}
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Storage getStorage(JsonNode node) {
		UUID id = mapper.convertValue(node, UUID.class);
		return dao.get(id);
	}	*/
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Storage> addStorages(JsonNode node) {
		List<Storage> storages = Arrays.asList(mapper.convertValue(node, Storage[].class));
		return dao.addAll(storages);
	}
	
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Storage> deleteStorages(JsonNode node) {
		List<UUID> ids = Arrays.asList(mapper.convertValue(node, UUID[].class));
		return dao.deleteAll(ids);
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Storage> updateStorages(JsonNode node) {
		List<Storage> storages = Arrays.asList(mapper.convertValue(node, Storage[].class));
		return dao.updateAll(storages);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Storage> getStorages() {
		return dao.getAll();
	}
}
