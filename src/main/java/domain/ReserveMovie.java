package domain;

import java.util.HashMap;

public class ReserveMovie {
    private HashMap<Integer, Integer> reservation = new HashMap<>();

    public ReserveMovie() {

    }

    public void addMovie(Integer movieId, Integer reservationNumber) {
        reservation.put(movieId, reservationNumber);
    }
}
