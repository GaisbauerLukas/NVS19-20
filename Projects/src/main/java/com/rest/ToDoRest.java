package com.rest;

import com.entity.ToDo;
import com.service.ToDoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ToDoRest {
    @Inject
    ToDoService toDoService;

    @Path("new")
    @POST
    public Response createToDo(ToDo toDo){
        toDoService.createToDo(toDo);

        return Response.ok(toDo).build();
    }

    @Path("update")
    @PUT
    public Response updateToDo(ToDo toDo){
        toDoService.updateToDo(toDo);
        return Response.ok(toDo).build();
    }

    @Path("{id}")
    @GET
    public ToDo getTodo(@PathParam("id") Long id){
        return toDoService.findToDoById(id);
    }

    @Path("list")
    @GET
    public List<ToDo> getToDos(){
        return toDoService.getTodos();
    }
}
