import domain.Movie;
import domain.MovieRepository;
import domain.ReservationInfo;
import domain.ReservationRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        ReservationRepository reservationRepository = new ReservationRepository();

        int movieId;
        int scheduleNumber;
        int reservationCount;
        int quitOrAdditionalReservation;
        int pointCount;
        int paymentMethod;

        do {
            OutputView.printMovies(movies);

            movieId = InputView.inputMovieId();
            OutputView.printMovie(movies, movieId);

            scheduleNumber = InputView.inputScheduleNumber(movieId);
            reservationCount = InputView.inputReservationCount(movieId, scheduleNumber);
            quitOrAdditionalReservation = InputView.inputQuitOrAdditionalReservation();

            reservationRepository.add(new ReservationInfo(movieId, scheduleNumber, reservationCount));
        } while (quitOrAdditionalReservation == 2);

        OutputView.printReservationResult(reservationRepository);

        pointCount = InputView.inputPointCount();
        paymentMethod = InputView.inputPaymentMethod();
    }
}
