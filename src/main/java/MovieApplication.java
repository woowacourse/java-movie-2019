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
        while(!MovieRepository.isContainMovieId(movieId)){
            System.out.println(InputView.NOT_MOVIE_ID);
            movieId = InputView.inputMovieId();
        }
        Movie userSelectMovie = MovieRepository.getMovie(movieId);
        System.out.println(userSelectMovie);

        int scheduleId = InputView.inputScheduleId();
        while(!userSelectMovie.isCorrectSheduleId(scheduleId)){
            scheduleId = InputView.inputScheduleId();
        }
        while(!userSelectMovie.isPossibleWatch(scheduleId)){
            System.out.println(InputView.NOT_MOVIE_SCHEDULE);
            scheduleId = InputView.inputScheduleId();
        }

    }
}
