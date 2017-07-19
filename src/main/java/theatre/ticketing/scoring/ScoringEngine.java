package theatre.ticketing.scoring;

import theatre.ticketing.model.IRow;
import theatre.ticketing.model.IScoredSeat;
import theatre.ticketing.model.ISeat;
import theatre.ticketing.model.Theatre;

import java.util.ArrayList;
import java.util.List;

public class ScoringEngine {

    public ScoringEngine(Theatre theatre, List<IScoringStrategy> strategies) {
        this.theatre = theatre;
        this.setStrategies(strategies);
    }

    public void scoreSeats() {
        if (getTheatre() == null) {
            return;
        }

        for (int i = 0; i < this.getTheatre().getRowCount(); i++) {
            this.score(this.getTheatre().getRow(i));
        }

        for (int i = 0; i < this.getTheatre().getRowCount(); i++) {
            this.normalize(this.getTheatre().getRow(i));
        }
    }

    public void setStrategies(List<IScoringStrategy> strategies) {
        if (strategies == null) {
            return;
        }

        this.strategies = strategies;
    }

    public List<IScoringStrategy> getStrategies() {
        if (strategies == null) {
            return new ArrayList<>();
        }

        return this.strategies;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Theatre getTheatre() {
        if (theatre == null) {
            theatre = new Theatre();
        }

        return theatre;
    }

    private void score(IRow row) {
        if (row == null || row.getSeats() == null) {
            return;
        }

        for (ISeat seat : row.getSeats()) {
            if (!(seat instanceof IScoredSeat)) {
                continue;
            }

            double seatScore = 0.0d;
            for (IScoringStrategy strategy : strategies) {
                seatScore += strategy.score((IScoredSeat)seat);
            }

            ((IScoredSeat)seat).setScore(seatScore);
            greatestDistance = Math.max(greatestDistance, seatScore);
        }
    }

    private void normalize(IRow row) {
        if (row == null || row.getSeats() == null) {
            return;
        }

        for (ISeat seat : row.getSeats()) {
            if (!(seat instanceof IScoredSeat)) {
                continue;
            }

            double seatScore = ((IScoredSeat)seat).getScore();
            ((IScoredSeat)seat).setScore(
                    Math.abs((greatestDistance - seatScore)/greatestDistance)
            );
            seatScore = Math.max(greatestDistance, seatScore);
        }
    }

    private List<IScoringStrategy> strategies;
    private Theatre theatre;
    private double greatestDistance = Double.MIN_VALUE;
}
