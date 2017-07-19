package theatre.ticketing.scoring;
import theatre.ticketing.model.*;

public class OptimalSeatBasedDistanceStrategy implements IScoringStrategy, IOptimalSeatBasedScoring {

    public OptimalSeatBasedDistanceStrategy(Theatre theatre) {
        this.setTheatre(theatre);
    }

    @Override
    public double score(IScoredSeat seat) {
        return calculateDistance(seat);
    }

    @Override
    public ISeat getOptimalSeat() {
        if (optimalSeat == null) {
            optimalSeat = doGetOptimalSeat();
        }

        return optimalSeat;
    }

    private ISeat doGetOptimalSeat() {
        if (theatre == null) {
            return new NullSeat();
        }

        int optimalRow = ((int)Math.floor(theatre.getRowCount()))/2;

        IRow row = theatre.getRow(optimalRow);
        if (row == null || row.getSeats() == null || row.getSeats().size() == 0) {
            return new NullSeat();
        }

        int optimalCol = ((int)Math.floor(row.getSeats().size()))/2;
        return row.getSeats().get(optimalCol);
    }

    private double calculateDistance(ISeat seat) {
        return Math.sqrt(Math.pow(seat.getColumn() - getOptimalSeat().getColumn(), 2) +
                Math.pow(seat.getRow() - getOptimalSeat().getRow(), 2));
    }

    public Theatre getTheatre() {
        return this.theatre;
    }

    private void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    private Theatre theatre;
    private ISeat optimalSeat;
}
