import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.Map;

public class MovieApplication {
    public static void main(String[] args) {
        Map<Integer, Movie> movieList = MovieRepository.getMovieMap();
        OutputView.printMovies(movieList);

        do {
            int movieId = InputView.inputMovieId();
            Movie selectedMovie = movieList.get(movieId);
            OutputView.printMovieInfo(selectedMovie);
            int movieTime = InputView.inputSchedule(selectedMovie);
            int movieNumberOfPeople = InputView.inputNumberOfPeople(selectedMovie, movieTime);
            OutputView.printReservation(selectedMovie, movieTime, movieNumberOfPeople);
        }
        while (InputView.inputEndOrRestart() == 2);


        // TODO 구현 진행
    }
}
