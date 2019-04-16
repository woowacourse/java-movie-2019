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
        Movie movie;
        PlaySchedule playSchedule;
        int movieSchedule;
        int personnel;

        do {
            int movieId = InputView.inputMovieId();
            movie = OutputView.printMovieSchedule(movies, movieId);
        } while (movie == null);
        addSelectMovie(selectMovies, movie);

        do {
            movieSchedule = InputView.inputMovieSchedule();
            playSchedule = movie.getPlaySchedules().get(movieSchedule - 1);
        } while (addSelectSchedules(playSchedules, playSchedule, movieSchedule));

        do {
            personnel = InputView.inputPersonnel();
        } while (playSchedule.checkCapacity(personnel));

    }

    public static void addSelectMovie(List<Movie> selectMovies, Movie movie) {
        selectMovies.add(movie);
    }

    public static boolean addSelectSchedules(List<PlaySchedule> playSchedules, PlaySchedule playSchedule, int movieSchedule) {
        try {
            playSchedules.add(playSchedule);
            return false;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("범위를 벗어났습니다.");
            return true;
        }
    }
}
