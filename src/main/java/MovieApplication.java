import domain.Billing;
import domain.Movie;
import domain.MovieRepository;
import domain.ReserveMovie;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        ReserveMovie reservationMovie = new ReserveMovie();
        reservationMovie.reserve();
        Billing.billing(reservationMovie);
    }
}
