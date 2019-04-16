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
            Movie aMovie = InputView.inputMovieId();
            OutputView.printAMovie(aMovie);

            int movieTime = InputView.inputMovieTime(aMovie);
            int reserveCount = InputView.inputReserveCount();

            process = InputView.inputChooseProcess();
            reservationList.add(aMovie, reserveCount, movieTime);
        } while (process == 2);

        OutputView.printReserveList(reservationList);

        OutputView.printProcessMessage();

        PayInfo payInfo = getPayInfo();
        OutputView.printPayResult(payInfo.getTotalPriceApplyPayInfo(reservationList));
    }

    private static PayInfo getPayInfo() {
        int pointAmount = InputView.inputPointAmount();
        int payType = InputView.inputPayType();

        return new PayInfo(pointAmount, payType);
    }
}
