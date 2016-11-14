package ee.joel.skeleton;

import ee.joel.skeleton.component.ApplicationComponent;
import ee.joel.skeleton.component.DaggerApplicationComponent;
import ee.joel.skeleton.configuration.WebConfiguration;
import ee.joel.skeleton.module.DatabaseModule;
import ee.joel.skeleton.module.ResourceModule;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.views.freemarker.FreemarkerViewRenderer;
import org.skife.jdbi.v2.DBI;

import static com.google.common.collect.Lists.newArrayList;

public class StartApplication extends Application<WebConfiguration> {

    public static void main(String[] args) throws Exception {
        new StartApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<WebConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/staatiline", "index.html", "static"));
        bootstrap.addBundle(new ViewBundle(newArrayList(new FreemarkerViewRenderer())));
    }

    @Override
    public void run(WebConfiguration configuration, Environment environment) throws ClassNotFoundException {
        DBI db = new DBIFactory().build(environment, configuration.getDataSourceFactory(), "H2");

        ApplicationComponent component;
        component = DaggerApplicationComponent.builder()
                .resourceModule(new ResourceModule())
                .databaseModule(new DatabaseModule(db))
                .build();
        environment.jersey().register(component.indexResource());
        environment.jersey().setUrlPattern("/*");

    }
}
