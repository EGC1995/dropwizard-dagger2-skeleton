package ee.joel.skeleton.configuration;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class SchemaCreator {
    private static final Logger LOGGER = getLogger(SchemaCreator.class);

    public static void initializeDatabases(DBI dbi) {
        try (Handle h = dbi.open()) {
            h.execute("CREATE TABLE IF NOT EXISTS sampleTable (\n" +
                    "  id BIGINT,\n" +
                    "  PRIMARY KEY (id));");

        } catch (Exception e) {
            LOGGER.error("Failed to update schema", e);
        }
    }
}
