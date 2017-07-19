package theatre.ticketing.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class SeatTest {

    @Test
    public void TestSeatNumber() {
        Seat seat = new Seat("G3");
        assertEquals(6, seat.getRow());
        assertEquals(2, seat.getColumn());
    }
}
