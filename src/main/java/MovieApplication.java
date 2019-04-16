import domain.Movie;
import domain.MovieRepository;
import domain.PayInfo;
import domain.ReservationList;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        ReservationList reservationList = new ReservationList();

        OutputView.printMovies(movies);

        // TODO 구현 진행
        int process;
        do {
            int movieId = InputView.inputMovieId();

            Movie aMovie = MovieRepository.getMovieById(movieId);
            OutputView.printAMovie(aMovie);

            int movieTime = InputView.inputMovieTime();
            int reserveCount = InputView.inputReserveCount();

            process = InputView.inputChooseProcess();
            reservationList.add(aMovie, reserveCount, movieTime);
        } while (process == 2);

        OutputView.printReserveList(reservationList);

        OutputView.printProcessMessage();
        int pointAmount = InputView.inputPointAmount();

        int payType = InputView.inputPayType();

        PayInfo payInfo = new PayInfo(pointAmount, payType);
        OutputView.printPayResult(payInfo.getTotalPriceApplyPayInfo(reservationList));
    }
}
