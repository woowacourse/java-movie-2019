package domain;

import java.util.ArrayList;
import java.util.List;

public class ReservationStorage {
    private List<ReservedMovie> moviesToReserve = new ArrayList<>();

    public void addReservation(ReservedMovie reservedMovie) {
        moviesToReserve.add(reservedMovie);
    }

    public List<ReservedMovie> getMoviesToReserve() {
        return moviesToReserve;
    }
}
