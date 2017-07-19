package theatre.ticketing.scoring;
import theatre.ticketing.model.IScoredSeat;

public interface IScoringStrategy {
    double score(IScoredSeat seat);
}
