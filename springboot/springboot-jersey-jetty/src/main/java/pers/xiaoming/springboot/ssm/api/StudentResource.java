package pers.xiaoming.springboot.ssm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.xiaoming.springboot.ssm.entity.Student;
import pers.xiaoming.springboot.ssm.service.IStudentService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/student")
public class StudentResource {

    private IStudentService service;

    @Autowired
    public StudentResource(IStudentService service) {
        this.service = service;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudent(Student student) {
        service.createStudent(student);

        return Response.status(Response.Status.CREATED).entity(student.toString()).build();
    }

    @GET
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    public Response getStudent(@QueryParam("id") int id) {
        Student student = service.getStudent(id);

        return Response.ok(student.toString()).build();
    }

}
