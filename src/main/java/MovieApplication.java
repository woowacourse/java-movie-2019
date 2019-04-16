import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        Movie movieOfId = MovieRepository.getMovie(movieId);
        OutputView.printMovie(movieOfId);

        int movieScheduleNum = InputView.inputMovieScheduleNum();
        PlaySchedule playSchedule = MovieRepository.playScheduleOfMovieOfNum(movieOfId, movieScheduleNum);
        // TODO 구현 진행
    }
}
