package theatre.ticketing.service;

import theatre.ticketing.model.ISeat;
import theatre.ticketing.model.Screening;

public interface IBookingService {

    void book(Screening screening, ISeat seat);
}
