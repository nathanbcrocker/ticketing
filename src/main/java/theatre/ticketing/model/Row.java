package theatre.ticketing.model;

import java.util.*;
import java.util.stream.Collectors;

public class Row implements IRow {

    public Row() {}
    public Row(List<ISeat> seats) {
        this.addSeats(seats);
    }

    @Override
    public int getRowNumber() {
        return rowNumber;
    }

    @Override
    public void addSeats(List<ISeat> seats) {
        if (rowSeats == null) {
            rowSeats = new TreeSet<>(
                    (e1, e2) -> e1.compareTo(e2));
        }

        if (seats == null) {
            return;
        }

        rowNumber = seats.get(0).getRow();
        rowSeats.addAll(seats);
    }

    @Override
    public List<ISeat> getSeats() {
        return rowSeats.stream().collect(Collectors.toList());
    }

    private int rowNumber = -1;
    private Set<ISeat> rowSeats;
}
