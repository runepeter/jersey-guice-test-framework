package no.jforce.jersey.guice.example;

import com.google.inject.AbstractModule;
import no.jforce.jersey.guice.resource.BallsResource;

public class ApplicationResourcesModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(BallsResource.class);
    }
}
