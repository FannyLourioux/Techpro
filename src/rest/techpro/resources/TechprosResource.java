package rest.techpro.resources;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.techpro.dao.ComputerDao2;
import rest.techpro.model.Computer;
import rest.techpro.model.Techpro;



/// Will map the resource to the URL todos
@Path("/techpro")
public class TechprosResource {
	
    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of todos to the user in the browser
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Computer> getTodosBrowser() {
        List<Computer> todos = new ArrayList<Computer>();
        System.out.println("Ici");
        todos.addAll(ComputerDao2
        		.getInstance()
        		.getModel()
        		.values());
         return todos;
    }

    	/*
    // Return the list of todos for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Techpro> getTodos() {
        List<Techpro> todos = new ArrayList<Techpro>();
        todos.addAll(ComputerDao.instance.getModel().values());
        return todos;
    }

    // retuns the number of todos
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/todos/count
    // to get the total number of records
    @GET
    @Path("counts")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = ComputerDao.instance.getModel().size();
        return String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newTodo(@FormParam("id") String id,
            @FormParam("summary") String summary,
            @FormParam("description") String description,
            @Context HttpServletResponse servletResponse) throws IOException {
        Techpro todo = new Techpro(id, summary);
        if (description != null) {
            todo.setDescription(description);
        }
        ComputerDao.instance.getModel().put(id, todo);

        servletResponse.sendRedirect("../create_todo.html");
    }*/

}