import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class MovieApplication {
    public static void main(String[] args) {
        Map<Integer, Movie> movieList = MovieRepository.getMovieMap();
        OutputView.printMovies(movieList);

        int movieId = InputView.inputMovieId();
        Movie selectedMovie = movieList.get(movieId);
        OutputView.printMovieInfo(selectedMovie);
        int movieTime = InputView.inputSchedule(selectedMovie);
        int movieNumberOfPeople = InputView.inputNumberOfPeople(selectedMovie, movieTime);


        // TODO 구현 진행
    }
}
