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

        Movie selectedMovie = getPlaySchedulesOfSelectedMovie();        // 영화 선택
        PlaySchedule selectedPlaySchedule = getPlayScheduleByNumber(selectedMovie);
        System.out.println(setReservedAllMovieToList(selectedPlaySchedule));
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

    private static List<PlaySchedule> setReservedAllMovieToList(PlaySchedule playSchedule) {
        List<PlaySchedule> reservedMovies = new ArrayList<>();
        reservedMovies.add(playSchedule);
        return reservedMovies;
    }

    private static PlaySchedule getPlayScheduleByNumber(Movie selectedMovie) {
        try {
            int scheduleId = InputView.inputMovieScheduleId();             // 시간표 선택
            return selectedMovie.getPlaySchedules().get(scheduleId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPlayScheduleByNumber(selectedMovie);
        }
    }
}
