package pers.xiaoming.javaweb.jetty.api;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Slf4j
@Path("/jetty/hello_world")
public class HelloWorldResource {

    @GET
    @Path("/msg")
    @Produces("text/plain")
    public String getHello() {
        log.info("hello world servlet GET");
        return "Hello World";
    }

    @GET
    @Path("/request_class")
    @Produces("text/plain")
    public String get(@Context HttpServletRequest request,
                      @Context HttpServletRequest response) {
        log.info("Request Class in hello world resource : " + request.getClass());
        log.info("Response Class in hello world resource : " + response.getClass());
        return "Hello World";
    }
}
