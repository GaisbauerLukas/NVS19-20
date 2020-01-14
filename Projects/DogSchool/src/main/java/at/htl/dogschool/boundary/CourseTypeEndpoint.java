package at.htl.dogschool.boundary;

import at.htl.dogschool.control.CourseTypeRepository;
import at.htl.dogschool.entity.CourseType;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("api")
public class CourseTypeEndpoint {

    @Path("course_type")
    @GET
    public List<CourseType> readAll() {
        return CourseTypeRepository.getAll();
    }
    @Path("course_type")
    @POST
    public Response create(CourseType courseType, @Context UriInfo info) {
        CourseTypeRepository.createCourseType(courseType);
        return Response.ok(courseType).build();
    }

    @Path("{id}")
    @PUT
    public Response update(@PathParam("id") long id, CourseType courseType) {
        CourseTypeRepository.updateCourseType(courseType);
        return Response.ok(courseType).build();
    }
    @Path("{id}")
    @DELETE
    public Response delete(@PathParam("id") long id) {
        CourseTypeRepository.deleteCourseType(id);
        return Response.ok().build();
    }


}
