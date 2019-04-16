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
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        // 영화 선택
        Movie aMovie = MovieRepository.getMovieById(movieId);
        OutputView.printAMovie(aMovie);

        ReservationList reservationList = new ReservationList();

        int process;
        do {
            int movieTime = InputView.inputMovieTime();
            int reserveCount = InputView.inputReserveCount();

            process = InputView.inputChooseProcess();
            OutputView.printReserveList(aMovie, movieTime, reserveCount);
            reservationList.add(aMovie, reserveCount);
        } while (process == 2);

        OutputView.printProcessMessage();
        int pointAmount = InputView.inputPointAmount();

        int payType = InputView.inputPayType();

        PayInfo payInfo = new PayInfo(pointAmount, payType);
        OutputView.printPayResult(payInfo.getTotalPriceApplyPayInfo(reservationList));
    }
}
