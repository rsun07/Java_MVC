package pers.xiaoming.javamvc.jetty.exception.exceptionmapper;

import lombok.extern.slf4j.Slf4j;
import pers.xiaoming.javamvc.jetty.exception.HandledException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class HandledExceptionMapper implements ExceptionMapper<HandledException> {
    @Override
    public Response toResponse(HandledException exception) {
        log.error("Handled Exception");
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
