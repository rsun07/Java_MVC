package pers.xiaoming.javamvc.jetty.api;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/jetty/context")
public class ContextResource {

    @GET
    @Produces("text/plain")
    public Response get(
            @Context HttpHeaders headers,
            @Context HttpServletRequest request,
            @Context HttpServletRequest response) {
        log.info("Header Class : " + headers.getClass());
        log.info("Request Class : " + request.getClass());
        log.info("Response Class : " + response.getClass());
        return Response.ok().build();
    }
}
