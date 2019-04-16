import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        // 예약 시도
        MovieReserver reserver = new MovieReserver(new ReservationFactory());
        List<MovieReservation> reservations =  reserver.reserveMovies(movies);

        // 결제
        pay();
    }

    public static void pay() {
        System.out.println("결제시도!");
    }
}
