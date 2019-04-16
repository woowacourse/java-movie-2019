import domain.BookedMovie;
import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static final int MIN_RESERVED_PERSON_COUNT = 1;
    private static final int PAY_WITH_CREDIT_CARD = 1;
    private static final int PAY_WITH_CASH = 2;
    private static List<BookedMovie> bookedMovies;

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        bookedMovies = new ArrayList<>();
        boolean isBooking = true;
        while (isBooking) {
            OutputView.printMovies(movies);
            int movieId = getValidMovieId();
            BookedMovie bookedMovie = bookOneMovie(movieId);
            bookedMovies.add(bookedMovie);
            isBooking = InputView.inputAdditionalReservation() == 2;
        }
        OutputView.printBookedMovies(bookedMovies);
        int finalCharge = handlePayment();
        OutputView.printReservationSummary(finalCharge);
    }

    private static int getValidMovieId() {
        int movieId = InputView.inputMovieId();
        if (MovieRepository.isValidMovieId(movieId)
                && !checkMovieBooked(movieId)) {
            return movieId;
        }
        return getValidMovieId();
    }

    private static boolean checkMovieBooked(int movieId) {
        for (BookedMovie b : bookedMovies) {
            if (b.checkMovieId(movieId)) {
                return true;
            }
        }
        return false;
    }

    private static BookedMovie bookOneMovie(int movieId) {
        Movie selectedMovie = MovieRepository.getMovieById(movieId);
        assert selectedMovie != null;

        BookedMovie bookedMovie = new BookedMovie(selectedMovie);
        OutputView.printSelectedMovie(selectedMovie);

        PlaySchedule selectedSchedule = decideSchedule(selectedMovie, bookedMovie);
        decidePersonCount(bookedMovie, selectedSchedule);
        return bookedMovie;
    }

    private static PlaySchedule decideSchedule(Movie selectedMovie, BookedMovie bookedMovie) {
        int scheduleId = InputView.inputScheduleId();
        PlaySchedule selectedSchedule = selectedMovie.getScheduleById(scheduleId);
        while (selectedSchedule == null) {
            scheduleId = InputView.inputScheduleId();
            selectedSchedule = selectedMovie.getScheduleById(scheduleId);
        }
        bookedMovie.updateSchedule(selectedSchedule);
        return selectedSchedule;
    }

    private static void decidePersonCount(BookedMovie bookedMovie, PlaySchedule selectedSchedule) {
        int personCount = InputView.inputPersonCount();
        while (!selectedSchedule.reserveTickets(personCount, MIN_RESERVED_PERSON_COUNT)) {
            personCount = InputView.inputPersonCount();
        }
        bookedMovie.updateReservedPersonCount(personCount);
    }

    private static int handlePayment() {
        OutputView.printPaymentGuide();
        int totalCharge = calTotalCharge();
        int pointToUse = getValidPointToUse(totalCharge);
        int paymentMethod = getPaymentMethod();
        return calFinalCharge(totalCharge, pointToUse, paymentMethod);
    }

    private static int calTotalCharge() {
        int totalCharge = 0;
        for (BookedMovie b : bookedMovies) {
            totalCharge += b.getChargePerMovie();
        }
        return totalCharge;
    }

    private static int getValidPointToUse(int totalCharge) {
        int pointInput = InputView.inputPoint();
        while (pointInput > totalCharge) {
            OutputView.printPointExceededWarining(totalCharge);
            pointInput = InputView.inputPoint();
        }
        return pointInput;
    }

    private static int getPaymentMethod() {
        int paymentMethod = InputView.inputPaymentMethod();
        while ((paymentMethod != PAY_WITH_CREDIT_CARD)
                && (paymentMethod != PAY_WITH_CASH)) {
            paymentMethod = InputView.inputPaymentMethod();
        }
        return paymentMethod;
    }

    private static int calFinalCharge(int totalCharge, int pointToUse, int paymentMethod) {
        int chargeAfterPoint = totalCharge - pointToUse;
        if (paymentMethod == PAY_WITH_CREDIT_CARD) {
            return (int)(chargeAfterPoint * 0.95);
        }
        return (int)(chargeAfterPoint * 0.98);
    }
}
