import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static Movie getMovieFromId(int movieId) {
        return MovieRepository.getMovie(movieId).get(0);
    }

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        Movie movie = getMovieFromId(movieId);
        System.out.println(movie);

        int scheduleId = InputView.inputScheduleId(movie);
        int reservationNumber
                = InputView.inputReservationNumber(movie, scheduleId);

        // TODO 구현 진행
    }
}
