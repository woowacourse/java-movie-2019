import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        //int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        String whatMovie = InputView.askUserWhatMovie();
        Movie selectedMovie = MovieRepository.findAndReturnMovie(movies, whatMovie);
        System.out.println(selectedMovie);
        String whatTime = InputView.askUserWhatTime(selectedMovie);
        String howManyPeople = InputView.askUserHowManyPeople();



    }
}
