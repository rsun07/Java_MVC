package pers.xiaoming.javamvc.jetty.api;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Map;

@Slf4j
@Path("/jetty/params")
public class ParamResource {

    @GET
    @Path("/params/{str}")
    @Produces("text/plain")
    public Response getParams(
            @CookieParam("param_cookie") String cookie,
            @PathParam("str") String pathStr,
            @DefaultValue("query_str") @QueryParam("query_str") String queryStr,
            @QueryParam("query_int") Integer queryInt
    ) {
        log.info("Cookie is {}, Path String is {}, Query String is {}, Query int is {}",
                cookie, pathStr, queryStr, queryInt);
        return Response.ok().build();
    }

    @GET
    @Path("uri/{str}")
    @Produces("text/plain")
    public Response getUriParams(
            @Context HttpHeaders headers,
            @Context UriInfo uri
            ) {
        MultivaluedMap<String, String> headerParams = headers.getRequestHeaders();
        Map<String, Cookie> cookies = headers.getCookies();

        MultivaluedMap<String, String> pathParams = uri.getPathParameters();
        MultivaluedMap<String, String> queryParams = uri.getQueryParameters();

        log.info("Cookie is {}, headers are {},  Path params are {}, Query params are {}",
                cookies, headerParams, pathParams, queryParams);
        return Response.ok().build();
    }
}
