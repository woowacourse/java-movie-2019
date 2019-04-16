import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        List<MovieReservation> reservationList = new ArrayList<>();

        do {
            MovieReservation reservation = reservationMovie();

            reservationList.add(reservation);
        } while (InputView.inputRestart());

        paymentMovie(reservationList);
    }

    public static MovieReservation reservationMovie() {
        int movieId = InputView.inputMovieId();
        OutputView.printSelectMovie(movieId);
        int movieTime = InputView.inputMovieTime(movieId);
        int capacity = InputView.inputMovieCapacity(movieId, movieTime);
        return new MovieReservation(movieId, movieTime, capacity);
    }

    public static void paymentMovie(List<MovieReservation> reservationList) {
        OutputView.printReservation(reservationList);
        System.out.println("## 결제를 진행합니다.");
        int point = InputView.inputPoint();
        int payWith = InputView.inputSelectPayWith();
        OutputView.printResultPay(point, payWith, reservationList);
    }

}
