package theatre.ticketing.model;

public class ScoredSeat implements IScoredSeat {

    public ScoredSeat() {
        this(new Seat());
    }

    public ScoredSeat(String seatNumber) {
        this.seat = new Seat(seatNumber);
    }

    public ScoredSeat(ISeat seat) {
        ISeat s = seat;

        if (s == null) {
            s = new Seat();
        }

        this.seat = s;
    }

    @Override
    public String getSeatNumber() {
        return getSeat().getSeatNumber();
    }

    @Override
    public int getRow() {
        return getSeat().getRow();
    }

    @Override
    public void setRow(int row) {
        getSeat().setRow(row);
    }

    @Override
    public int getColumn() {
        return getSeat().getColumn();
    }

    @Override
    public void setColumn(int column) {
        getSeat().setColumn(column);
    }

    @Override
    public boolean isAvailable() {
        return this.getSeat().isAvailable();
    }

    @Override
    public void setStatus(SeatStatus status) {
        this.getSeat().setStatus(status);
    }

    @Override
    public SeatStatus getStatus() {
        return this.getSeat().getStatus();
    }

    @Override
    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public double getScore() {
        return this.score;
    }

    @Override
    public int compareTo(ISeat seat) {
        return this.getSeat().compareTo(seat);
    }

    private ISeat getSeat() {
        return this.seat;
    }

    private double score;
    private ISeat seat;
}
