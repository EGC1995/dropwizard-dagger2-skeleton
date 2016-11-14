package ee.joel.skeleton.acceptancetest;

import ee.joel.skeleton.acceptancetest.configuration.AcceptanceTestComponent;
import ee.joel.skeleton.StartApplication;
import ee.joel.skeleton.acceptancetest.actor.VisitorActor;
import ee.joel.skeleton.acceptancetest.configuration.DaggerAcceptanceTestComponent;
import ee.joel.skeleton.configuration.WebConfiguration;
import ee.joel.skeleton.module.DatabaseModule;
import ee.joel.skeleton.module.ResourceModule;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.skife.jdbi.v2.DBI;

import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;

public class BaseAcceptanceTestComponent {
    private static DBI dbi;
    public AcceptanceTestComponent component;
    public VisitorActor visitor;

    @ClassRule
    public static final DropwizardAppRule<WebConfiguration> RULE =
            new DropwizardAppRule<>(StartApplication.class, resourceFilePath("dropwizardConfig.yml"));

    @BeforeClass
    public static void setUpClass() {
        dbi = new DBIFactory().build(RULE.getEnvironment(), RULE.getConfiguration().getDatabase(), "db");
    }

    public BaseAcceptanceTestComponent() {
        component = DaggerAcceptanceTestComponent.builder()
                .databaseModule(new DatabaseModule(dbi))
                .resourceModule(new ResourceModule())
                .build();
        visitor = component.visitorActor();
    }


    @AfterClass
    public static void tearDown() throws Exception {
        RULE.getEnvironment().getApplicationContext().stop();
    }
}
