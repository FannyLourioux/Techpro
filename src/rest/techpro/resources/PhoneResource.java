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

import rest.techpro.dao.PhoneDao;
import rest.techpro.model.Phone;

@Path("/phones")
public class PhoneResource {
	private PhoneDao dao = PhoneDao.getInstance();
	ObjectMapper mapper = new ObjectMapper();
	
	@Context UriInfo uriInfo;
    @Context Request request;
	
    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Phone addPhone(JsonNode node) {
    	Phone phone = mapper.convertValue(node, Phone.class);
		return dao.add(phone);
	}
    
	// TODO -> Useless to return a deleted phone
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Phone deletePhone(JsonNode node) {
		Phone phone = mapper.convertValue(node, Phone.class);
		return dao.delete(phone); 
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Phone updatePhone(JsonNode node) {
		Phone phone = mapper.convertValue(node, Phone.class);
		return dao.update(phone);
	}
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Phone getPhone(JsonNode node) {
		UUID id = mapper.convertValue(node, UUID.class);
		return dao.get(id);
	}	*/
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Phone> addPhones(JsonNode node) {
		List<Phone> phones = Arrays.asList(mapper.convertValue(node, Phone[].class));
		return dao.addAll(phones);
	}
	
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Phone> deletePhones(JsonNode node) {
		List<UUID> ids = Arrays.asList(mapper.convertValue(node, UUID[].class));
		return dao.deleteAll(ids);
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Phone> updatePhones(JsonNode node) {
		List<Phone> phones = Arrays.asList(mapper.convertValue(node, Phone[].class));
		return dao.updateAll(phones);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Phone> getPhones() {
		return dao.getAll();
	}
}
