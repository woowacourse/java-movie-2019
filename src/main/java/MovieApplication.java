import domain.Movie;
import domain.MovieRepository;
import domain.ReserveMovie;
import view.InputView;
import view.OutputView;
import java.util.ArrayList;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<ReserveMovie> reserveMovies = new ArrayList<>();
        OutputView.printMovies(movies);
        boolean additionalTicketing = true;

        int movieId = InputView.inputMovieId();
        Movie currentMovie = MovieRepository.searchMovies(movieId, 0);
        OutputView.printMovie(currentMovie);

        while (additionalTicketing) {
            int movieTimeTable = InputView.inputTimetable();
            int movieNumOfPerson = InputView.inputNumOfPerson();
            additionalTicketing = InputView.inputAdditionalTicketing();
            reserveMovies.add(new ReserveMovie(currentMovie, currentMovie.getPlaySchedules().get(movieTimeTable), movieNumOfPerson));
        }
        OutputView.printHistory(reserveMovies);
        //int point = InputView.inputPayment();
        //int credit = InputView.inputCreditCard();

    }
}
