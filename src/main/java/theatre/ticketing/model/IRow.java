package theatre.ticketing.model;

import java.util.List;

public interface IRow {

    int getRowNumber();
    void addSeats(List<ISeat> seats);
    List<ISeat> getSeats();
}
