package theatre.ticketing.scoring;

import theatre.ticketing.model.*;

import org.junit.Test;
import java.util.Arrays;

import static  org.junit.Assert.*;

public class ScoringEngineTest {

    @Test
    public void TestScoring() throws RowException {
        IRow one = new Row( Arrays.asList( new ISeat[] { new ScoredSeat("A1"), new ScoredSeat("A2"), new ScoredSeat("A3") }));
        IRow two = new Row( Arrays.asList( new ISeat[] { new ScoredSeat("B2"), new ScoredSeat("B1") }));
        IRow three = new Row( Arrays.asList( new ISeat[] { new ScoredSeat("C1"), new ScoredSeat("C3"), new ScoredSeat("C4"), new ScoredSeat("C2"), new ScoredSeat("C5") }));

        Theatre theatre = new Theatre();
        theatre.addRow(one);
        theatre.addRow(two);
        theatre.addRow(three);

        ScoringEngine engine = new ScoringEngine(theatre, Arrays.asList(new OptimalSeatBasedDistanceStrategy(theatre)));
        engine.scoreSeats();

        assertEquals("B2", ((OptimalSeatBasedDistanceStrategy)engine.getStrategies().get(0)).getOptimalSeat().getSeatNumber());
        assertEquals(0.68d, ((IScoredSeat)one.getSeats().get(1)).getScore(), 0.01d);
        assertEquals(01.0d, ((IScoredSeat)two.getSeats().get(1)).getScore(), 0.01d);
    }
}
