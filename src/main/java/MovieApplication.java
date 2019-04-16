import domain.*;
import view.OutputView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MovieApplication {
    public static void showMovieList() {
        List<Movie> movies = MovieRepository.getMovies();

        OutputView.printMovies(movies);
    }

    public static void main(String[] args) {
        HashMap<MovieId, Reservation> reservations = new LinkedHashMap<>();

        do {
            showMovieList();

            Reservation reservation = ReservationManager.getReservation();
            ReservationManager.addReservationTo(reservations, reservation);
        } while(ReservationManager.continueReservation());

        ReservationManager.startPaymentOf(reservations);
    }
}
