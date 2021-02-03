package rest.techpro.resources;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.techpro.dao.ComputerDao;
import rest.techpro.model.Computer;

@Path("/computers")
public class ComputerResource {
	private ComputerDao dao = ComputerDao.getInstance();
	
	@Context UriInfo uriInfo;
    @Context Request request;
	
	public Computer addComputer(Computer computer) {
		return dao.add(computer);
	}
	
	// TODO -> Useless to return a deleted computer
	public Computer deleteComputer(Computer computer) {
		return dao.delete(computer); 
	}
	
	public Computer updateComputer(Computer computer) {
		return dao.update(computer);
	}
	
	public Computer getComputer(UUID id) {
		return dao.get(id);
	}	
	
	public Set<Computer> addComputers(List<Computer> computers) {
		return dao.addAll(computers);
	}
	
	public Set<Computer> deleteComputers(List<Computer> computers) {
		return dao.deleteAll(computers);
	}
	
	public Set<Computer> updateComputers(List<Computer> computers) {
		return dao.updateAll(computers);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Computer> getComputers() {
		return dao.getAll();
	}
}
