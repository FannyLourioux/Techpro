package rest.techpro.resources;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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

@Path("/items")
public class ItemsResource {
	private ItemDao dao = ItemDao.getInstance();
	ObjectMapper mapper = new ObjectMapper();
	
	@Context UriInfo uriInfo;
    @Context Request request;
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> addItems(JsonNode node) {
		List<Item> computers = Arrays.asList(mapper.convertValue(node, Item[].class));
		return dao.addAll(computers);
	}
	
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> deleteItems(JsonNode node) {
		List<UUID> ids = Arrays.asList(mapper.convertValue(node, UUID[].class));
		return dao.deleteAll(ids);
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> updateItems(JsonNode node) {
		List<Item> computers = Arrays.asList(mapper.convertValue(node, Item[].class));
		return dao.updateAll(computers);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getItems() {
		return dao.getAll();
	}
	
	@Path("ids")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public List<Item> getFromIds(JsonNode node) {
		List<UUID> ids = Arrays.asList(mapper.convertValue(node, UUID[].class));
		return ids.stream().map(id -> dao.get(id)).collect(Collectors.toList());
	}
	
	@GET
	@Path("pc/fixes")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getPcsFixes() {
		return dao.getPcsFixes();
	}
	
	@GET
	@Path("pc/portables")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getPcsPortabless() {
		return dao.getPcsPortables();
	}
	
	@GET
	@Path("pc/accessoires")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getPcsAccessoires() {
		return dao.getAccessoiresPc();
	}
	
	@GET
	@Path("pc")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getPcs() {
		return dao.getPcs();
	}
	
	@GET
	@Path("telephone/fixes")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getTelephonesFixes() {
		return dao.getTelephonesFixes();
	}
	
	@GET
	@Path("telephone/portables")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getTelephonesPortabless() {
		return dao.getTelephonesPortables();
	}
	
	@GET
	@Path("telephone/accessoires")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getTelephonesAccessoires() {
		return dao.getAccessoiresTelephone();
	}
	
	@GET
	@Path("telephone")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getTelephones() {
		return dao.getTelephones();
	}
	
	@GET
	@Path("stockage/cles")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getClesUsb() {
		return dao.getClesUsb();
	}
	
	@GET
	@Path("stockage/disques")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getDisquesDurs() {
		return dao.getDisquesDurs();
	}
	
	@GET
	@Path("stockage/accessoires")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getStockageAccessoires() {
		return dao.getAccessoiresStockage();
	}	
	
	@GET
	@Path("stockage")
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Item> getStockages() {
		return dao.getStockages();
	}
}
