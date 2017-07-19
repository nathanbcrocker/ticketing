package theatre.ticketing.model;

public interface ISeat {

    enum SeatStatus { Booked, Reserved, Available };

    String getSeatNumber();
    //void setSeatNumber(String seatNumber);

    int getRow();
    void setRow(int row);

    int getColumn();
    void setColumn(int column);

    boolean isAvailable();

    void setStatus(SeatStatus status);
    SeatStatus getStatus();

    int compareTo(ISeat value);
}
