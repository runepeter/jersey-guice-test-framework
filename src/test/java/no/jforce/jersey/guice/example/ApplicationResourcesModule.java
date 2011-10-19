package no.jforce.jersey.guice.example;

import com.google.inject.AbstractModule;
import no.jforce.jersey.guice.example.repository.BallRepository;
import no.jforce.jersey.guice.example.repository.HashMapBallRepository;
import no.jforce.jersey.guice.example.resource.BallsResource;

public class ApplicationResourcesModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(BallRepository.class).toInstance(new HashMapBallRepository());
        bind(BallsResource.class);
    }
}
