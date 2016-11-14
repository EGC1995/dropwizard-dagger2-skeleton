package ee.joel.skeleton.repository;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.ManagedDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.skife.jdbi.v2.DBI;

import static ee.joel.skeleton.configuration.SchemaCreator.initializeDatabases;


@Ignore
public class BaseIntegrationTest {

    private static DataSourceFactory dataSourceFactory;
    private static ManagedDataSource dataSource;
    protected static DBI dbi;

    @BeforeClass
    public static void setUpClass() {
        dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setUrl("jdbc:h2:mem:test-" + System.currentTimeMillis());
        dataSourceFactory.setUser("anyUser");
        dataSourceFactory.setPassword("");
        dataSourceFactory.setDriverClass("org.h2.Driver");
        dataSource = dataSourceFactory.build(null, "random");
        dbi = new DBI(dataSource);
        initializeDatabases(dbi);
    }

    @Before
    public void createDatabase() throws Exception {

    }

    @After
    public void cleanDatabase() throws Exception {
        dataSource.stop();
    }
}