package domain;

import java.util.HashMap;
import java.util.Map;

public class Reservation {
    private Map<Movie, Integer> reservation  = new HashMap<>();

    public void addReservation(Movie movie, int watcher) {
        reservation.put(movie, watcher);
    }
}
