import domain.Movie;
import domain.MovieRepository;
import domain.ReserveMovie;
import domain.Ticketing;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<ReserveMovie> reserveMovies = new ArrayList<>();
        OutputView.printMovies(movies);
        boolean additionalTicketing = true;

        while (additionalTicketing) {
            reserveMovies.add(Ticketing.startTitcketing());
            additionalTicketing = InputView.inputAdditionalTicketing();
        }
        OutputView.printHistory(reserveMovies);
        Ticketing.startPayment(reserveMovies);
    }
}
