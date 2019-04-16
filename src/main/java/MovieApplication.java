import domain.Movie;
import domain.MovieRepository;
import jdk.internal.util.xml.impl.Input;
import utils.Data;
import utils.Result;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = Data.getMovieId(InputView.inputMovieId());
        OutputView.printMovieInfo(movies.get(movieId).toString());

        Result result = new Result(movies, movieId);
        result.startMovieResult();
    }

}
