package ee.joel.skeleton.module;

import dagger.Module;
import dagger.Provides;
import org.skife.jdbi.v2.DBI;

import javax.inject.Named;
import javax.inject.Singleton;


@Module
public class DatabaseModule {

    private DBI db;

    public DatabaseModule(DBI db) {
        this.db = db;
    }

    @Provides
    @Singleton
    DBI provideDBI() {
        return db;
    }

}