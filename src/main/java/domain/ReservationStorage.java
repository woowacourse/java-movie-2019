package domain;

import java.util.ArrayList;
import java.util.List;

public class ReservationStorage {
    private List<MovieToReserve> moviesToReserve = new ArrayList<>();

    public void addReservation(MovieToReserve movieToReserve) {
        moviesToReserve.add(movieToReserve);
    }
}
