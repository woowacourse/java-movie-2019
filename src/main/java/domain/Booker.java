package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Booker {
    private List<Movie> reservationMovies;
    private List<Integer> reservationTime;

    private int tryReservationNumber = 0;

    public Booker(int movieId) {
        reservationMovies = new ArrayList<>();
        reservationTime = new ArrayList<>();
        addReservationMovie(movieId);
    }

    public void addReservationMovie(int movieId) {
        reservationMovies.add(MovieRepository.getMovie(movieId));
    }

    public void reservationTime() {
        reservationTime.add(InputView.inputReservationTime(reservationMovies.get(tryReservationNumber)));
    }
}
