package no.jforce.jersey.guice.example;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import no.jforce.jersey.guice.test.GuiceAndJerseyTest;
import org.junit.Test;

public class BallResourceTestCase extends GuiceAndJerseyTest
{
    @Test
    public void testJalla() throws Exception {

        WebResource resource = resource().path("/balls");

        ClientResponse response = resource.get(ClientResponse.class);

    }
}
