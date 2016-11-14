package ee.joel.skeleton.module;

import dagger.Module;
import dagger.Provides;
import ee.joel.skeleton.resource.IndexResource;

import javax.inject.Singleton;

@Module
public class ResourceModule {

    @Provides
    @Singleton
    IndexResource provideIndexResource() {
        return new IndexResource();
    }


}