import domain.Movie;
import domain.MovieRepository;
import domain.Purchase;
import domain.ReservedMovie;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        OutputView.outputReservedMovie(movies, movieId);

        int movieTime = InputView.inputMovieTime();
        int movieNumberOfPeople = InputView.inputMovieNumberOfPeople();

        ReservedMovie reservedMovie = new ReservedMovie(movies);
        reservedMovie.addReservationHistory(movieId, movieTime, movieNumberOfPeople);

        reservedMovie.printReservationHistory();

        Purchase purchase = new Purchase(reservedMovie.calculateTotalPrice());
        purchase.printTotalPrice();
    }
}
