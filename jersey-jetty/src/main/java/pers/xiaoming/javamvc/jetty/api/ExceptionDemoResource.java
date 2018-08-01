package pers.xiaoming.javamvc.jetty.api;

import lombok.extern.slf4j.Slf4j;
import pers.xiaoming.javamvc.jetty.exception.HandledException;
import pers.xiaoming.javamvc.jetty.exception.NotHandledException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/jetty/exception")
public class ExceptionDemoResource {

    @GET
    @Produces("text/plain")
    public Response mappedException(
            @QueryParam("handled") boolean handled
    ) throws HandledException {
        if (handled) {
            log.info("Executing handled/mapped exception resource");
            throw new HandledException("Exception handled/mapped");
        } else {
            log.info("Executing not handled/mapped exception resource");
            throw new NotHandledException("Exception handled/mapped");
        }
    }
}
