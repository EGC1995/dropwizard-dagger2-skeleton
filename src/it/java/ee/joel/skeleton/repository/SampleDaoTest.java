package ee.joel.skeleton.repository;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.skife.jdbi.v2.Handle;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;


public class SampleDaoTest extends BaseIntegrationTest {
    private SampleDao sampleDao;

    @Before
    public void setUp() throws Exception {
        sampleDao = dbi.open(SampleDao.class);
        try (Handle h = dbi.open()) { h.execute("DELETE FROM sampleTable;"); }
    }

    @Test
    public void canSaveAndReturnIds() throws Exception {
        int randomId = saveRandomId();
        int randomId2 = saveRandomId();

        List<Integer> answer = sampleDao.getAll();
        assertThat(answer, containsInAnyOrder(randomId, randomId2));
    }

    private int saveRandomId() {
        int randomId = RandomUtils.nextInt(0, 42000);
        sampleDao.put(randomId);
        return randomId;
    }

}