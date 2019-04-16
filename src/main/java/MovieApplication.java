import domain.Booker;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    private Booker bookProcessing() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Booker booker = new Booker();

        do {
            booker.selectMovie();
            OutputView.printMovie(booker.currentBookingMovieId());
            booker.selectBookingTime();
            booker.selectBookingNumber();
        } while (!InputView.inputPayProcessing());

        return booker;
    }

    private void processOfPayment(Booker booker) {
        OutputView.printResultBooking(booker);
        int point = InputView.inputPoint();
        int paymentType = InputView.inputPaymentType();
        OutputView.printMoney(booker.getTotalPrice(paymentType, point));
    }

    public static void main(String[] args) {
        MovieApplication movieApplication = new MovieApplication();
        Booker booker;

        booker = movieApplication.bookProcessing();
        movieApplication.processOfPayment(booker);
    }
}
