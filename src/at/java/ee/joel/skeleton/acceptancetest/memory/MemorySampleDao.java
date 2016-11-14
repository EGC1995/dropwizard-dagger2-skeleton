package ee.joel.skeleton.acceptancetest.memory;

import ee.joel.skeleton.repository.SampleDao;
import org.skife.jdbi.v2.sqlobject.Bind;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

public class MemorySampleDao implements SampleDao {

    private Set<Integer> ids = newHashSet();

    @Override
    public void put(@Bind("id") int id) {
        ids.add(id);
    }

    @Override
    public List<Integer> getAll() {
        return newArrayList(ids);
    }
}
