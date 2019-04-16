import domain.Booking;
import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import model.MovieBookingModel;
import service.PaymentType;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static final int SELECT_GOTO_PAY = 1;
    private static final int SELECT_ADDITIONAL_BOOK = 2;

    private static MovieBookingModel movieBookingModel = new MovieBookingModel();
    private static List<Movie> movies = MovieRepository.getMovies();

    public static void main(String[] args) {
        List<Booking> bookings = getBookings();
        int point = getPoint(movieBookingModel.getTotalPrice(bookings));
        PaymentType pt = getPaymentType();
        int payed = movieBookingModel.bookWithPay(bookings, point, pt);
        OutputView.printFinished(payed);
    }

    private static List<Booking> getBookings() {
        List<Booking> bookings = new ArrayList<>();
        int sel = SELECT_ADDITIONAL_BOOK;
        OutputView.printMovies(movies);
        while (sel == SELECT_ADDITIONAL_BOOK) {
            bookings.add(getBooking());
            sel = getSelectioinForAdditionalBook();
        }

        if (!movieBookingModel.isBookableTogether(bookings)) {
            OutputView.printUnbookableTogether();
            return getBookings();
        }

        return bookings;
    }

    private static Booking getBooking() {
        Movie m = getMovie();
        PlaySchedule s = getSchedule(m);
        Booking b = new Booking(m, s, getNumOfPeople(s));

        if (!movieBookingModel.isBookable(b)) {
            OutputView.printUnbookableSchedule();
            return getBooking();
        }
        return b;
    }

    private static Movie getMovie() {
        int movieId = InputView.inputMovieId();
        Movie m = movieBookingModel.retrieveMovieById(movieId);
        while (m == null) {
            OutputView.printInvalidInput();
            movieId = InputView.inputMovieId();
            m = movieBookingModel.retrieveMovieById(movieId);
        }
        return m;
    }

    private static PlaySchedule getSchedule(Movie m) {
        List<PlaySchedule> schedules = m.getPlaySchedules();
        int scheduleNum = InputView.inputMovieScheduleTime(m);
        while (scheduleNum > schedules.size() ||
            scheduleNum <= 0) {
            OutputView.printInvalidInput();
            scheduleNum = InputView.inputMovieScheduleTime(m);
        }

        return schedules.get(scheduleNum - 1);
    }

    private static int getNumOfPeople(PlaySchedule schedule) {
        int numOfPeople = InputView.inputMovieScheduleNumOfPeople();
        while (!schedule.isCapable(numOfPeople)) {
            OutputView.printInvalidInput();
            numOfPeople = InputView.inputMovieScheduleNumOfPeople();
        }
        return numOfPeople;
    }

    private static int getSelectioinForAdditionalBook() {
        int sel = InputView.inputPayOrMoreBook();
        while (sel != SELECT_GOTO_PAY &&
            sel != SELECT_ADDITIONAL_BOOK) {
            OutputView.printInvalidInput();
            sel = InputView.inputPayOrMoreBook();
        }
        return sel;
    }

    private static int getPoint(int totalPrice) {
        int point = InputView.inputPoint();
        while (point < 0 || point > totalPrice) {
            OutputView.printInvalidInput();
            point = InputView.inputPoint();
        }

        return point;
    }

    private static PaymentType getPaymentType() {
        PaymentType pt = PaymentType.valueOf(InputView.inputPaymentType());
        while (pt == null) {
            OutputView.printInvalidInput();
            pt = PaymentType.valueOf(InputView.inputPaymentType());
        }
        return pt;
    }

}
