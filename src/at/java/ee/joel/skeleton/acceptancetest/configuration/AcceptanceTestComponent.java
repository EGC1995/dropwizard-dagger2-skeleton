package ee.joel.skeleton.acceptancetest.configuration;

import dagger.Component;
import ee.joel.skeleton.acceptancetest.configuration.module.ActorsModule;
import ee.joel.skeleton.acceptancetest.actor.VisitorActor;
import ee.joel.skeleton.module.DatabaseModule;
import ee.joel.skeleton.module.ResourceModule;

import javax.inject.Singleton;

@Singleton
@Component(modules={DatabaseModule.class,
                    ResourceModule.class,
                    ActorsModule.class})
public interface AcceptanceTestComponent {
    VisitorActor visitorActor();
}