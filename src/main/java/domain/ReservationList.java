package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReservationList {
    private Map<Movie, Integer> reservationCountList = new HashMap<>();
    private Map<Movie, Integer> reservationTimeList = new HashMap<>();

    public void add(Movie movie, Integer count, Integer timeId) {
        reservationCountList.put(movie, count);
        reservationTimeList.put(movie, timeId);
    }

    public Set<Movie> getMovieSet() {
        return this.reservationCountList.keySet();
    }

    public Integer getCountByMovie(Movie movie) {
        return reservationCountList.get(movie);
    }

    public Integer getTimeByMovie(Movie movie) {
        return reservationTimeList.get(movie);
    }

    int getTotalPrice() {
        int totalPrice = 0;
        for (Movie movie : reservationCountList.keySet()) {
            int eachPrice = movie.getPrice() * reservationCountList.get(movie);
            totalPrice += eachPrice;
        }
        return totalPrice;
    }
}
