import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        OutputView.selectMovies(movies, movieId);

        int movidDatatime = InputView.inputMovieDataTime();

        OutputView.userMovie_SelectDatatime(movidDatatime);

        int moviePerson = InputView.inputMoviePerson();

        OutputView.userMovie_SelectCapacity(moviePerson);


    }
}
