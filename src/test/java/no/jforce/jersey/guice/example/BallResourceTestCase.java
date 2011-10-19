package no.jforce.jersey.guice.example;

import com.google.inject.Inject;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import no.jforce.jersey.guice.example.repository.BallRepository;
import no.jforce.jersey.guice.example.repository.HashMapBallRepository;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class BallResourceTestCase extends GuiceAndJerseyTest
{
    @Inject
    private BallRepository repository;

    @Test
    public void testGetAll() throws Exception {

        WebResource resource = resource().path("/balls");

        ClientResponse response = resource.get(ClientResponse.class);
        
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(HashMapBallRepository.class.getName(), response.getEntity(String.class));
    }

    @Test
    public void testCreateNewBall() throws Exception {

        WebResource resource = resource().path("/balls");

        Form form = new Form();
        form.add("color", "RED");

        ClientResponse response = resource.post(ClientResponse.class, form);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertEquals(getBaseURI() + "balls/1", response.getLocation().toString());
    }

    @Test
    public void testUpdateExistingBall() throws Exception
    {
        int id = repository.addNewBall("RED");

        WebResource resource = resource().path("/balls/" + id);

        Form form = new Form();
        form.add("color", "GREEN");

        ClientResponse response = resource.put(ClientResponse.class, form);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("GREEN", repository.getBall(1));
    }

    @Test
    public void testDeleteExistingBall() throws Exception {

        int id = repository.addNewBall("RED");

        WebResource resource = resource().path("/balls/" + id);
        ClientResponse response = resource.delete(ClientResponse.class);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

}
