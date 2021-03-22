package rest.techpro.resources;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.ws.rs.PathParam;
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

import rest.techpro.dao.ItemDao;
import rest.techpro.model.Item;

@Path("/item")
public class ItemResource {
	private ItemDao dao = ItemDao.getInstance();
	ObjectMapper mapper = new ObjectMapper();
	
	@Context UriInfo uriInfo;
    @Context Request request;
	
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Item addItem(JsonNode node) {
    	System.out.println(node);
		Item item = mapper.convertValue(node, Item.class);
		return dao.add(item);
	}
	
    @DELETE
    @Path("/{param}")
	public void deleteItems(@PathParam("param") UUID param) {
    	System.out.println("TOTO");
    	dao.delete(param);
    	System.out.println(dao.get(param));
	}	
	
    /*
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> updateItems(JsonNode node, @PathParam x) {
		List<Item> computers = Arrays.asList(mapper.convertValue(node, Item[].class));
		return dao.updateAll(computers);
	}*/
}
