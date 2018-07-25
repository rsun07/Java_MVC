package pers.xiaoming.javaweb.jetty.api.utils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/health")
public class Health {

    @GET
    @Produces("text/plain")
    public final Response health() {
        return Response.ok().build();
    }
}
