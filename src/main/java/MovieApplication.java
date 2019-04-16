import domain.Movie;
import domain.MovieRepository;
import domain.Purchase;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    private static final int ADDITIONAL_INPUT = 2;

    private static Reservation reservation;
    private static List<Movie> movies = MovieRepository.getMovies();

    public static void main(String[] args) {
        OutputView.printMovies(movies);

        reservation = new Reservation(movies);

        choiceMovie();

        reservation.printReservationHistory();

        Purchase purchase = new Purchase(reservation.calculateTotalPrice());
        int point = InputView.inputPoint();
        int methodOfPayment = InputView.inputCarOrCash();
        purchase.printTotalPayment(point, methodOfPayment);
    }

    private static void choiceMovie() {
        do {
            int movieId = InputView.inputMovieId();
            OutputView.outputReservedMovie(movies, movieId);

            int movieTime = InputView.inputMovieTime();
            int movieNumberOfPeople = InputView.inputMovieNumberOfPeople();

            reservation.addReservationHistory(movieId, movieTime, movieNumberOfPeople);
        } while (isAdditionalInput());
    }

    private static boolean isAdditionalInput() {
        boolean result = false;
        if (InputView.checkAdditionalInput() == ADDITIONAL_INPUT) {
            result = true;
        }
        return result;
    }
}
