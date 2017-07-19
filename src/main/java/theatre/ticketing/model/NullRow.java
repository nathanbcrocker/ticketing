package theatre.ticketing.model;

import java.util.ArrayList;
import java.util.List;

public class NullRow implements IRow {

    @Override
    public int getRowNumber() {
        return 0;
    }

    @Override
    public void addSeats(List<ISeat> seats) {

    }

    @Override
    public List<ISeat> getSeats() {
        return new ArrayList<ISeat>();
    }
}
