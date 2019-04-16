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
        int quitOrAdditionalReservation;

        OutputView.printMovies(movies);
        movieId = InputView.inputMovieId();

        while (!ValidatorUtils.isNaturalMovieId(movieId)) {
            movieId = InputView.inputMovieId();
        }

        OutputView.printMovie(movies, movieId);
        scheduleNumber = InputView.inputScheduleNumber();

        while (!ValidatorUtils.isNaturalScheduleNumber(movieId, scheduleNumber)) {
            scheduleNumber = InputView.inputScheduleNumber();
        }

        reservationCount = InputView.inputReservationCount();

        while (!ValidatorUtils.isNaturalReservationCount(movieId, scheduleNumber, reservationCount)) {
            reservationCount = InputView.inputReservationCount();
        }

        quitOrAdditionalReservation = InputView.inputQuitOrAdditionalReservation();

        while (!ValidatorUtils.isNaturalResponseForQuit(quitOrAdditionalReservation)) {
            quitOrAdditionalReservation = InputView.inputQuitOrAdditionalReservation();
        }

    }
}
