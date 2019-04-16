import domain.Movie;
import domain.MovieRepository;
import utils.ValidatorUtils;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        int movieId;
        int scheduleNumber;
        int reservationCount;

        OutputView.printMovies(movies);

        movieId = InputView.inputMovieId();

        OutputView.printMovie(movies, movieId);

        scheduleNumber = InputView.inputScheduleNumber();

        while (!ValidatorUtils.isNaturalScheduleNumber(movieId, scheduleNumber)) {
            scheduleNumber = InputView.inputScheduleNumber();
        }

        reservationCount = InputView.inputReservationCount();

        while (!ValidatorUtils.inNaturalReservationCount(movieId, scheduleNumber, reservationCount)) {
            reservationCount = InputView.inputReservationCount();
        }

    }
}
