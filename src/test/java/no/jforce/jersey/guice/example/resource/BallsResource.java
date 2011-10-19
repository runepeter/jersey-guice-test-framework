package no.jforce.jersey.guice.example.resource;

import com.google.inject.Inject;
import no.jforce.jersey.guice.example.repository.BallRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/balls")
public class BallsResource
{
    @Inject
    private BallRepository repository;

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") int id)
    {
        return Response.ok(repository.getBall(id)).build();
    }

    @POST
    public Response create(@FormParam("color") String color, @Context UriInfo uriInfo)
    {
        int id = repository.addNewBall(color);

        URI location = uriInfo.getAbsolutePathBuilder().path("/" + id).build();

        return Response.created(location).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") int id, @FormParam("color") String color)
    {
        repository.updateColor(id, color);

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id)
    {
        repository.deleteBall(id);

        return Response.ok().build();
    }

    @GET
    public Response getAll()
    {
        return Response.ok(repository.getClass().getName()).build();
    }

}
