package theatre.ticketing.scoring;

import theatre.ticketing.model.IScoredSeat;

public class EqualScoringStrategy implements IScoringStrategy {

    public EqualScoringStrategy() {
        this(1.0d);
    }

    public EqualScoringStrategy(double score) {
        setScore(score);
    }

    @Override
    public double score(IScoredSeat seat) {
        return this.getScore();
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return this.score;
    }

    private double score = 0.0d;
}
