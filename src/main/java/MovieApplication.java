import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static Movie getMovieFromId(int movieId) {
        return MovieRepository.getMovie(movieId).get(0);
    }

    public static boolean changeValueOfContinue(int inputNumber) {
        if (inputNumber == 2 ) {
            return true;
        }
        return false;
    }

    public static int getTotalPrice(List<MovieReservation> reservations) {
        int totalPrice = 0;

        for (MovieReservation reservation : reservations) {
            totalPrice += reservation.getTotalPrice();
        }

        return totalPrice;
    }

    public static double getFinalPrice(int totalPrice,
                                    int usedPoint, int payment) {
        double discountPrice = 0.95;

        if (payment == 2) {
            discountPrice = 0.98;
        }

        return (totalPrice - usedPoint) * discountPrice;
    }

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<MovieReservation> reservations = new ArrayList<>();
        boolean isContinue = true;

        while (isContinue) {
            OutputView.printMovies(movies);

            int movieId = InputView.inputMovieId();
            Movie movie = getMovieFromId(movieId);
            System.out.println(movie);

            int scheduleId = InputView.inputScheduleId(reservations, movie);
            int reservationNumber
                    = InputView.inputReservationNumber(movie, scheduleId);

            MovieReservation reservation
                    = new MovieReservation(movie, scheduleId, reservationNumber);
            reservations.add(reservation);

            isContinue = changeValueOfContinue(InputView.inputIsContinue());
        }

        OutputView.printReservations(reservations);

        System.out.println("\n## 결재를 진행합니다.");
        int totalPrice = getTotalPrice(reservations);
        int usedPoint = InputView.inputPoint(totalPrice);
        int payment = InputView.inputPaymentMethod();
        double finalPrice = getFinalPrice(totalPrice, usedPoint, payment);

        OutputView.printFinalPrice(finalPrice);
    }
}
