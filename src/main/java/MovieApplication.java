import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        Movie selectedMovie = getPlaySchedulesOfSelectedMovie();
        int schecduleId = InputView.inputMovieScheduleId();
        List<PlaySchedule> playSchedules = selectedMovie.getPlaySchedules();
        System.out.println(playSchedules.get(schecduleId));
    }

    private static Movie getPlaySchedulesOfSelectedMovie() {
        try {
            int movieId = InputView.inputMovieId();
            return OutputView.getMoviePlaySchedule(movieId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPlaySchedulesOfSelectedMovie();
        }
    }

    private static List<Movie> setReservedAllMovieToList() {
        List<Movie> reservedMovies = new ArrayList<>();
        return reservedMovies;
    }
}
