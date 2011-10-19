package no.jforce.jersey.guice.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;
import no.jforce.jersey.guice.example.ApplicationResourcesModule;
import no.jforce.jersey.guice.example.test.GuiceInMemoryTestContainerFactory;

public abstract class GuiceAndJerseyTest extends JerseyTest
{
    @Override
    protected AppDescriptor configure()
    {
        Injector injector = Guice.createInjector(new ApplicationResourcesModule());
        injector.injectMembers(this);

        setTestContainerFactory(new GuiceInMemoryTestContainerFactory(injector));

        return new LowLevelAppDescriptor.Builder("ignore").contextPath("rest").build();
    }
}
