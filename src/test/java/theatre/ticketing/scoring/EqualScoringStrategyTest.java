package theatre.ticketing.scoring;

import theatre.ticketing.model.IScoredSeat;
import theatre.ticketing.model.ScoredSeat;
import org.junit.Test;

import static org.junit.Assert.*;

public class EqualScoringStrategyTest {

    @Test
    public void TestEqualScoring() throws Exception {
        IScoredSeat seat = new ScoredSeat();
        IScoringStrategy strategy = new EqualScoringStrategy(100.0d);
        assertEquals(100.0d, strategy.score(seat), 0.01d);
    }

}