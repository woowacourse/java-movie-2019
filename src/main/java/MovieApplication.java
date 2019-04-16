import domain.*;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {

    private static List<ReservingMovie> reservedMovies = new ArrayList<>();

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        boolean reservingProcess = true;
        while (reservingProcess) {
            int movieId = InputView.inputMovieId();
            Movie selectedMovie = MovieRepository.getMovieUsingMovieID(movieId);
            OutputView.printSelectedMovie(selectedMovie);
            addReservedMovie(selectedMovie);
            reservingProcess = (InputView.inputPaymentOrAddingReserve() == 2)
                    ? true : false;
        }
        OutputView.printDetailsOfReservingMovie(reservedMovies);
        startPayment(reservedMovies);
    }

    private static void addReservedMovie(Movie selectedMovie) {
        int moveStartTimeNumber = InputView.inputMovieStartTime();
        int numberOfPeople = InputView.inputNumberOfPeople();
        reservedMovies.add(new ReservingMovie(selectedMovie, moveStartTimeNumber, numberOfPeople));
    }

    private static int calculateTotalMoviePrice(List<ReservingMovie> reservedMovies) {
        int totalMoviePrice = 0;
        for (ReservingMovie reservedMovie : reservedMovies) {
            totalMoviePrice += reservedMovie.getPrice();
        }
        return totalMoviePrice;
    }

    private static void startPayment(List<ReservingMovie> reservedMovies) {
        int inputPoint = InputView.inputPoint();
        Point point = new Point(inputPoint);
        int paymentMethod = InputView.inputPaymentMethod();

        int totalMoviePrice = calculateTotalMoviePrice(reservedMovies);

        Pay pay = new Pay(point, totalMoviePrice);
        OutputView.printResultPrice(pay, paymentMethod);
    }

}
