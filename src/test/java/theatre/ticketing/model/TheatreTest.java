package theatre.ticketing.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TheatreTest {

    @Test
    public void TestAddRow() throws RowException {
        Theatre theatre = new Theatre();
        IRow row = row();

        theatre.addRow(row);
        List<ISeat> seats = theatre.getRow(0).getSeats();
        assertNotNull(seats);
        assertEquals("A3", seats.get(2).getSeatNumber());
    }

    @Test(expected = RowException.class)
    public void TestAddingSameRow() throws RowException
    {
        IRow row1 = row();
        IRow row2 = row();

        Theatre theatre = new Theatre();
        theatre.addRow(row1);
        theatre.addRow(row2);
    }

    private IRow row() {
        IRow row = new Row();
        row.addSeats(Arrays.asList(new Seat(0,2), new Seat(0,1), new Seat(0,0)));
        return row;
    }

}
