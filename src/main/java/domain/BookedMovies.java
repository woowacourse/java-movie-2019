package domain;

import java.util.HashMap;
import java.util.Map;

public class BookedMovies {
    private Map<MovieSchedule, Integer> bookedMovies = new HashMap<>();

    public void bookMovie(MovieSchedule movieSchedule, int personNumber) {
        bookedMovies.put(movieSchedule, personNumber);
    }
}