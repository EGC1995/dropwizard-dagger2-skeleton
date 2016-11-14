package ee.joel.skeleton.acceptancetest.actor;

import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Asserter;

import static org.junit.Assert.assertTrue;


public class VisitorActor implements Actor, Asserter {


    public VisitorActor() {
    }

    public void doesNothing() {
        // Nothing
    }

    public void nothingHasHappened() {
        assertTrue(true);
    }
}
