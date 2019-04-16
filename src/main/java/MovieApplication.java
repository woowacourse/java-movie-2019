import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MovieApplication {
    private static final int ARRAY_DEFAULT_VALUE = -1;
    private static final int QUIT_SIGNAL = 1;
    private static final int CONTINUE_SIGNAL = 2;
    private static final int PAY_CARD = 1;
    private static final double CARD_DISCOUNT = 0.95;
    private static final int PAY_CASH = 2;
    private static final double CASH_DISCOUNT = 0.98;

    private static List<Reservation> reservations;
    private static boolean isReserving;

    public static void main(String[] args) {
        isReserving = true;
        reservations = new ArrayList<>();
        List<Movie> movies = MovieRepository.getMovies();

        while (isReserving) {
            OutputView.printMovies(movies);
            makeReservation(movies);
        }
        OutputView.printReservations(reservations);

        pay();
    }

    public static boolean makeReservation(List<Movie> movies) {
        int movieId = InputView.inputMovieId();
        OutputView.printMovie(findMovieById(movies, movieId));
        int tableId = InputView.inputMovieTable() + ARRAY_DEFAULT_VALUE;
        int numPeople = InputView.inputNumPeople();
        if (!confirmReservation(findMovieById(movies, movieId), tableId, numPeople)) {
            OutputView.printErrorMessage();
            return false;
        }
        return enterQuitOrContinue();
    }

    public static boolean enterQuitOrContinue() {
        int quitSignal = InputView.inputQuitSignal();
        if (quitSignal == QUIT_SIGNAL) {
            isReserving = false;
            return true;
        } else if (quitSignal == CONTINUE_SIGNAL)
            return false;

        OutputView.printInputWrongValueMessage();
        return enterQuitOrContinue();
    }

    public static Movie findMovieById(List<Movie> movieList, int movieId) {
        for (Movie movie : movieList)
            if (movie.isSameMovieId(movieId))
                return movie;

        return null;
    }

    public static boolean confirmReservation(Movie movie, int tableId, int numPeople) {
        Reservation newReservation;

        if (movie.makeReserve(tableId, numPeople)) {
            newReservation = new Reservation(movie, tableId, numPeople);
            return checkAlreadyStarted(newReservation);
        }

        return false;
    }

    public static boolean checkAlreadyStarted(Reservation newReservation) {
        if (newReservation.isAlreadyStarted()) {
            return false;
        }
        return checkOutOfOneHourRange(newReservation);
    }

    public static boolean checkOutOfOneHourRange(Reservation newReservation) {
        for (Reservation reservation : reservations)
            if (!newReservation.checkOneHourWithinRange(reservation))
                return false;
        reservations.add(newReservation);
        return true;
    }

    public static void pay() {
        int point = 0;
        int payMethod = 0;
        try {
            point = InputView.inputPoint();
            payMethod = InputView.inputPayMethod();
        } catch (InputMismatchException e) {
            OutputView.printErrorMessage();
            pay();
        }
        OutputView.printReceipt(countTotalPrice(point, payMethod));
    }

    public static int countTotalPrice(int point, int payMethod) {
        int totalPrice = 0;
        for (Reservation reservation : reservations)
            totalPrice += reservation.getPricePerReservation();
        if (totalPrice <= point)
            return 0;
        if (payMethod == PAY_CARD) {
            totalPrice = (int) ((totalPrice - point) * CARD_DISCOUNT);
            return totalPrice;
        }
        return (int) ((totalPrice - point) * CASH_DISCOUNT);
    }

}