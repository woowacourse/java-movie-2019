import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static final int PAYMENT = 1;
    public static final int CONTINUE_BOOKING = 2;

    private static List<Movie> movies = MovieRepository.getMovies();
    private static Basket basket = new Basket();

    public static void main(String[] args) {
        BookingList bookingList = getBookingList();
        OutputView.printBookingList(bookingList);
    }

    private static BookingList getBookingList() {
        do {
            Booking booking = bookMovie();
            addBasket(booking);
        } while (isPaymentOrContinue());

        return new BookingList(basket.getBookingList());
    }

    private static Booking bookMovie() {
        try {
            OutputView.printMovies(movies);
            Movie selectedMovie = selectMovie();
            OutputView.printPlaySchedule(selectedMovie);

            int selectedPlaySchedule = InputView.selectPlaySchedule();
            int numberOfPeople = InputView.inputNumberOfPeople();
            return new Booking(selectedMovie, selectedPlaySchedule, numberOfPeople);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return bookMovie();
        }
    }

    private static Movie selectMovie() {
        try {
            int movieId = InputView.inputMovieId();
            return getMovie(movieId);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return selectMovie();
        }
    }

    private static Movie getMovie(int movieId) throws Exception {
        for (Movie movie : movies)
            if (movie.isIdSelected(movieId)) return movie;
        throw new Exception("선택하신 번호의 영화가 없습니다. 다시 입력해주세요.");
    }

    private static void addBasket(Booking booking) {
        try {
            basket.addBooking(booking);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }


    private static boolean isPaymentOrContinue() {
        try {
            int choice = InputView.inputStopOfContinue();

            return isValidInput(choice);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return isPaymentOrContinue();
        }
    }

    private static boolean isValidInput(int choice) {
        if (choice == PAYMENT)
            return false;
        else if (choice == CONTINUE_BOOKING)
            return true;
        throw new IllegalArgumentException("잘못 입력하셨습니다. 1또는 2 입력해주세요.");
    }
}
