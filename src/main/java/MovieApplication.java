import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        OutputView.printMovies(MovieRepository.getMovies(movieId));

        int movieTime = InputView.inputMovieTime();
        int movieViewer = InputView.inputMovieViewer();
        int payOrReserve = InputView.inputPayOrAdditionalReservation();

        //payOrReserve 값이 1일 경우 (결제 진행)
        OutputView.printReservationHistory(movieId, movieTime, movieViewer);
        int ticketPrice = OutputView.getTicketPrice(movieId, movieViewer);
        int point = InputView.inputPoint();
        double discountRate = InputView.inputCardOrCash();
        OutputView.printPayment(ticketPrice, point, discountRate);








    }
}
