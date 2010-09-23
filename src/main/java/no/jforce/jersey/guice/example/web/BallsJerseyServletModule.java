package no.jforce.jersey.guice.example.web;

import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class BallsJerseyServletModule extends JerseyServletModule
{
    @Override
    protected void configureServlets()
    {
        serve("/rest/*").with(GuiceContainer.class);
    }
}
