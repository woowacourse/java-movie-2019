import domain.Movie;
import domain.MovieRepository;
import service.MovieReservation;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        System.out.println(MovieReservation.getUserMovie().toString());

        // TODO 구현 진행
    }
}
