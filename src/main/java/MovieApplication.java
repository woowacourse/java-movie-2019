import domain.Movie;
import domain.MovieRepository;
import service.MovieReservation;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Movie movie = MovieReservation.getUserMovie();
        OutputView.printMovie(movie);
        MovieReservation.getMoiveTime(movie);
        // TODO 구현 진행
    }
}
