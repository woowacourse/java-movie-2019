import domain.ChoiceMovie;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static List<Movie> movies;
    public static List<ChoiceMovie> choiceMovies = new ArrayList<>();
    public static Movie choiceMovie;

    public static void main(String[] args) {
        movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행





    }

    public static void isContainId(Movie movie, int id) {
        if (movie.getId() == id) {
            System.out.println(movie);
            choiceMovie = movie;
        }
    }
}
