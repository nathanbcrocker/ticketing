package theatre.ticketing.model;

public class NullSeat implements ISeat {

    @Override
    public String getSeatNumber() {
        return "";
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public void setRow(int row) {

    }

    @Override
    public int getColumn() {
        return 0;
    }

    @Override
    public void setColumn(int column) {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void setStatus(SeatStatus status) {

    }

    @Override
    public SeatStatus getStatus() {
        return SeatStatus.Booked;
    }

    @Override
    public int compareTo(ISeat value) {
        return 0;
    }
}
