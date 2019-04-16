import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.PurchasedMovie;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<PurchasedMovie> purchasedMovies = new ArrayList<>();
        OutputView.printMovies(movies);

        int movieId;
        boolean continueBooking = true; //추가 예약 여부

        while (continueBooking) {
            movieId = InputView.inputMovieId();
            OutputView.printSchedule(movies, movieId);

            PlaySchedule playSchedule = InputView.inputMovieSchedule(movies ,movieId);
        }


    }
}
