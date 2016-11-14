package ee.joel.skeleton.acceptancetest.configuration.module;

import dagger.Module;
import dagger.Provides;
import ee.joel.skeleton.acceptancetest.actor.VisitorActor;

@Module
public class ActorsModule {

    @Provides
    public VisitorActor visitorActor(){
        return new VisitorActor();
    }

}
