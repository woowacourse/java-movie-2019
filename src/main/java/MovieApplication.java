import domain.BookedMovie;
import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static final int PAY_WITH_CREDIT_CARD = 1;
    private static final int PAY_WITH_CASH = 2;
    private static final int BOOKING_DONE = 1;
    private static final int BOOK_ANOTHER_MOVIE = 2;
    private static List<BookedMovie> bookedMovies;

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        bookedMovies = new ArrayList<>();
        boolean isBooking = true;
        while (isBooking) {
            OutputView.printMovies(movies);
            BookedMovie bookedMovie = bookOneMovie();
            bookedMovies.add(bookedMovie);
            isBooking = isBookingGoingOn();
        }
        OutputView.printBookedMovies(bookedMovies);
        int finalCharge = handlePayment();
        OutputView.printReservationSummary(finalCharge);
    }

    private static boolean isBookingGoingOn() {
        int isBooking = InputView.inputAdditionalReservation();
        while ((isBooking != BOOKING_DONE)
                && (isBooking != BOOK_ANOTHER_MOVIE)) {
            isBooking = InputView.inputAdditionalReservation();
        }
        return isBooking == BOOK_ANOTHER_MOVIE;
    }

    private static int getValidMovieId() {
        int movieId = InputView.inputMovieId();
        if (MovieRepository.isValidMovieId(movieId)
                && !checkMovieAlreadyBooked(movieId)) {
            return movieId;
        }
        return getValidMovieId();
    }

    private static boolean checkMovieAlreadyBooked(int movieId) {
        for (BookedMovie b : bookedMovies) {
            if (b.checkMovieId(movieId)) {
                OutputView.printAlreadyBookedWarning();
                return true;
            }
        }
        return false;
    }

    private static BookedMovie bookOneMovie() {
        int movieId = getValidMovieId();
        Movie selectedMovie = MovieRepository.getMovieById(movieId);
        assert selectedMovie != null;

        BookedMovie bookedMovie = new BookedMovie(selectedMovie);
        OutputView.printSelectedMovie(selectedMovie);

        PlaySchedule selectedSchedule =
                decideSchedule(selectedMovie, bookedMovie);
        if (!checkMovieTime(selectedSchedule) ||
                !decidePersonCount(bookedMovie, selectedSchedule)) {
            return bookOneMovie();
        }
        return bookedMovie;
    }

    private static PlaySchedule decideSchedule(Movie selectedMovie,
                                               BookedMovie bookedMovie) {
        int scheduleId = InputView.inputScheduleId();
        PlaySchedule selectedSchedule =
                selectedMovie.getScheduleById(scheduleId);
        while (selectedSchedule == null) {
            OutputView.printInvalidScheduleIdWarning();
            scheduleId = InputView.inputScheduleId();
            selectedSchedule = selectedMovie.getScheduleById(scheduleId);
        }
        bookedMovie.updateSchedule(selectedSchedule);
        return selectedSchedule;
    }

    private static boolean checkMovieTime(PlaySchedule selectedSchedule) {
        boolean isTimePassed = selectedSchedule.isStartTimePassed();
        boolean canBookTogether =
                isBookingTogetherValid(selectedSchedule);
        OutputView.printTimeWarning(isTimePassed, canBookTogether);
        return !isTimePassed && canBookTogether;
    }

    private static boolean isBookingTogetherValid(PlaySchedule selectedSchedule) {
        boolean isValid = true;
        for (BookedMovie b : bookedMovies) {
            isValid = b.isWithinOneHour(selectedSchedule);
        }
        return isValid;
    }

    private static boolean decidePersonCount(BookedMovie bookedMovie,
                                             PlaySchedule selectedSchedule) {
        int personCount = InputView.inputPersonCount();
        boolean isBooked = selectedSchedule.reserveTickets(personCount);
        if (isBooked) {
            bookedMovie.updateReservedPersonCount(personCount);
        }
        return isBooked;
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

    private static int calFinalCharge(int totalCharge, int pointToUse,
                                      int paymentMethod) {
        int chargeAfterPoint = totalCharge - pointToUse;
        if (paymentMethod == PAY_WITH_CREDIT_CARD) {
            return (int) (chargeAfterPoint * 0.95);
        }
        return (int) (chargeAfterPoint * 0.98);
    }
}
