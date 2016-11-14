package ee.joel.skeleton.component;

import dagger.Component;
import ee.joel.skeleton.module.DatabaseModule;
import ee.joel.skeleton.module.ResourceModule;
import ee.joel.skeleton.resource.IndexResource;

import javax.inject.Singleton;

@Singleton
@Component(modules={
    ResourceModule.class,
    DatabaseModule.class
})
public interface ApplicationComponent {

    IndexResource indexResource();

}