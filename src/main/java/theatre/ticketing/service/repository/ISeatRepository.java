package theatre.ticketing.service.repository;

import theatre.ticketing.model.ISeat;
import theatre.ticketing.model.Theatre;

import java.util.List;
import java.util.Set;

public interface ISeatRepository {

    List<Set<ISeat>> getSeating(Theatre theatre);

}
