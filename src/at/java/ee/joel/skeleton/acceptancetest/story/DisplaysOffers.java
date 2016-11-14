package ee.joel.skeleton.acceptancetest.story;

import ee.joel.skeleton.acceptancetest.BaseAcceptanceTestComponent;
import org.junit.Test;

import static com.shazam.gwen.Gwen.then;
import static com.shazam.gwen.Gwen.when;

public class DisplaysOffers extends BaseAcceptanceTestComponent {

    @Test
    public void inMorningsShowYesterdaysOffers() throws Exception {
        when(visitor).doesNothing();

        then(visitor).nothingHasHappened();
    }

}
