import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        OutputView.printMovies(MovieRepository.getMovies());
        
        MovieReservation movieReservation = new MovieReservation();
        
        movieReservation.reserve();
    }
}
