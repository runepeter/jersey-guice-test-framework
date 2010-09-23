package no.jforce.jersey.guice.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;
import no.jforce.jersey.guice.example.ApplicationResourcesModule;

public abstract class GuiceAndJerseyTest extends JerseyTest
{
    @Override
    protected AppDescriptor configure()
    {
        Injector injector = Guice.createInjector(new ApplicationResourcesModule());
        
        setTestContainerFactory(new GuiceInMemoryTestContainerFactory(injector));

        return new LowLevelAppDescriptor.Builder("ignore").contextPath("rest").build();
    }
}
