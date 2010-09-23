package no.jforce.jersey.guice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/balls")
public class BallsResource
{

    @GET
    public Response get()
    {
        return Response.ok("jalla").build();
    }

}
