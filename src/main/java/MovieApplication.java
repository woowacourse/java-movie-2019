import Program.BookSystem;
import Program.PaymentSystem;
import domain.BookMovie;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * BookSystem - 한 세트
 * bookingMovie = 예약중인 영화(인원 수 포함)
 * bookingMovieList = 예약중인 영화 정보
 *
 */
public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        BookSystem bookSystem = new BookSystem(new BookMovie());

        BookMovie bookingMovie = bookSystem.booking(movieId);
        List<Movie> bookingMovieList = bookingMovie.getBookMovieList();
        OutputView.printMovies(bookingMovieList);

        int ScheduleNumber = InputView.inputMovieSchedule();
        bookSystem.selectSchedule(0,ScheduleNumber);

        int inputPeopleBooking = InputView.inputPeopleBooking();
        bookSystem.selectPeopleBooking(inputPeopleBooking);

        PaymentSystem paymentSystem = new PaymentSystem();

        int inputPaymentType = InputView.inputPaymentType();
        paymentSystem.paymentStart(bookingMovie,inputPaymentType);
        OutputView.printTotalPrice(paymentSystem.getTotalPrice());

    }
}
