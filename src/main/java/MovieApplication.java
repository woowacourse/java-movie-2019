import domain.Movie;
import domain.MovieRepository;
import domain.Payment;
import domain.PaymentInfo;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) throws IOException {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        List<PaymentInfo> paymentInfos = new ArrayList<>();

        boolean wantPay = false;
        while (!wantPay) {
            int movieId = InputView.inputMovieId();
            List<Movie> selectedMovie = MovieRepository.getMoviesById(movieId);
            OutputView.printMovies(selectedMovie);

            int movieTime = InputView.inputMovieTime() - 1;
            int conutOfUser = InputView.inputCountOfUser();

            paymentInfos.add(new PaymentInfo(selectedMovie.get(0), movieTime, conutOfUser));

            wantPay = InputView.wantPay();
        }
        int payMoney = new Payment().pay(paymentInfos);
        OutputView.printPayResult(payMoney);
    }
}
