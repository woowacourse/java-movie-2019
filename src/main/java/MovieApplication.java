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

        List<Movie> selectMovies = new ArrayList<>();
        List<PlaySchedule> playSchedules = new ArrayList<>();
        Movie movie = null;

        do {
            int movieId = InputView.inputMovieId();
            movie = OutputView.printMovieSchedule(movies, movieId);
            addSelectMovie(selectMovies, movie);
        } while (movie == null);

        int movieSchedule = 0;

        do {
            movieSchedule = InputView.inputMovieSchedule();
        } while (addSelectSchedules(playSchedules, movie, movieSchedule));
    }

    public static void addSelectMovie(List<Movie> selectMovies, Movie movie) {
        selectMovies.add(movie);
    }

    public static boolean addSelectSchedules(List<PlaySchedule> playSchedules, Movie movie, int movieSchedule) {
        try {
            playSchedules.add(movie.getPlaySchedules().get(movieSchedule - 1));
            return false;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("범위를 벗어났습니다.");
            return true;
        }
    }
}
