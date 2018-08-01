package pers.xiaoming.springboot.ssm.exception.exceptionmapper;

import pers.xiaoming.springboot.ssm.exception.BadRequestException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Override
    @Produces(MediaType.TEXT_HTML)
    public Response toResponse(BadRequestException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
