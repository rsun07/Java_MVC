package pers.xiaoming.javaweb.jetty.api;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
}
