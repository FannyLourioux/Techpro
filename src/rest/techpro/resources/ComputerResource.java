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

import rest.techpro.dao.ComputerDao;
import rest.techpro.model.Computer;

@Path("/computers")
public class ComputerResource {
	private ComputerDao dao = ComputerDao.getInstance();
	ObjectMapper mapper = new ObjectMapper();
	
	@Context UriInfo uriInfo;
    @Context Request request;
	
    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Computer addComputer(JsonNode node) {
    	Computer computer = mapper.convertValue(node, Computer.class);
		return dao.add(computer);
	}
    
	// TODO -> Useless to return a deleted computer
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Computer deleteComputer(JsonNode node) {
		Computer computer = mapper.convertValue(node, Computer.class);
		return dao.delete(computer); 
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Computer updateComputer(JsonNode node) {
		Computer computer = mapper.convertValue(node, Computer.class);
		return dao.update(computer);
	}
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Computer getComputer(JsonNode node) {
		UUID id = mapper.convertValue(node, UUID.class);
		return dao.get(id);
	}	*/
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Computer> addComputers(JsonNode node) {
		List<Computer> computers = Arrays.asList(mapper.convertValue(node, Computer[].class));
		return dao.addAll(computers);
	}
	
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Computer> deleteComputers(JsonNode node) {
		List<UUID> ids = Arrays.asList(mapper.convertValue(node, UUID[].class));
		return dao.deleteAll(ids);
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Computer> updateComputers(JsonNode node) {
		List<Computer> computers = Arrays.asList(mapper.convertValue(node, Computer[].class));
		return dao.updateAll(computers);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Computer> getComputers() {
		return dao.getAll();
	}
}
