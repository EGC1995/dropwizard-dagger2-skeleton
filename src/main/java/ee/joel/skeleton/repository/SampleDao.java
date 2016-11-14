package ee.joel.skeleton.repository;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;

public interface SampleDao {

    @SqlUpdate("insert into sampleTable (id) values (:id)")
    void put(@Bind("id") int id);

    @SqlQuery("SELECT * FROM sampleTable")
    List<Integer> getAll();

}
