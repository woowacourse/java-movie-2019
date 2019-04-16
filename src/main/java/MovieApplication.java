import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        MovieReservation movieReservation = new MovieReservation();
        movieReservation.reservationMovie();
        // TODO 구현 진행
    }
}
