package no.jforce.jersey.guice.example.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import no.jforce.jersey.guice.example.ApplicationResourcesModule;

public class ApplicationGuiceWebConfig extends GuiceServletContextListener
{
    @Override
    protected Injector getInjector()
    {
        return Guice.createInjector(new ApplicationResourcesModule(), new BallsJerseyServletModule());
    }
}
