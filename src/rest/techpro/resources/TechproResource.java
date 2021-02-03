package rest.techpro.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import rest.techpro.dao.ComputerDao;
import rest.techpro.model.Computer;
import rest.techpro.model.Techpro;


public class TechproResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public TechproResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Computer getComputer() {
        Computer computer = ComputerDao.getInstance().getModel().get("ABC");
        if(computer==null)
            throw new RuntimeException("Get: Todo with " + "ABC" +  " not found");
        return computer;
    }

    	/*
    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Techpro getTodoHTML() {
        Techpro todo = ComputerDao.instance.getModel().get(id);
        if(todo==null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return todo;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putTodo(JAXBElement<Techpro> todo) {
        Techpro c = todo.getValue();
        return putAndGetResponse(c);
    }

    @DELETE
    public void deleteTodo() {
        Techpro c = ComputerDao.instance.getModel().remove(id);
        if(c==null)
            throw new RuntimeException("Delete: Todo with " + id +  " not found");
    }

    private Response putAndGetResponse(Techpro todo) {
        Response res;
        if(ComputerDao.instance.getModel().containsKey(todo.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        ComputerDao.instance.getModel().put(todo.getId(), todo);
        return res;
    }*/



}