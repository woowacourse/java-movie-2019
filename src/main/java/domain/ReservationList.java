package domain;

import java.util.HashMap;
import java.util.Map;

public class ReservationList {
    private Map<Movie, Integer> reservationList = new HashMap<>();

    public void add(Movie movie, Integer num) {
        reservationList.put(movie, num);
    }

    int getTotalPrice() {
        int totalPrice = 0;
        for (Movie movie : reservationList.keySet()) {
            int eachPrice = movie.getPrice() * reservationList.get(movie);
            totalPrice += eachPrice;
        }
        return totalPrice;
    }
}
