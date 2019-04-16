import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        List<Movie> selectMovies = new ArrayList<>();
        List<PlaySchedule> selectSchedules = new ArrayList<>();
        String nowStr = DateTimeUtils.format(LocalDateTime.now());
        LocalDateTime now = DateTimeUtils.createDateTime(nowStr);

        Movie movie;
        PlaySchedule playSchedule;
        int personnel;
        boolean isReservation;

        do {
            movie = selectMovie(movies, selectMovies);
            playSchedule = selectSchedule(selectSchedules, movie);
            personnel = selectPersonnel(playSchedule);
            isReservation = checkStartTime(playSchedule, now);
        } while (!isReservation);

        printMovie(selectMovies);
        printSchedule(selectSchedules);
    }

    public static boolean checkStartTime(PlaySchedule playSchedule, LocalDateTime now) {
        return playSchedule.checkStartDateTime(now);
    }

    public static int selectPersonnel(PlaySchedule playSchedule) {
        int personnel = InputView.inputPersonnel();
        boolean isCapacity = playSchedule.checkCapacity(personnel);

        if (isCapacity) {
            return selectPersonnel(playSchedule);
        }

        return personnel;
    }

    public static PlaySchedule selectSchedule(List<PlaySchedule> playSchedules, Movie movie) {
        playSchedules.clear();
        int movieSchedule = InputView.inputMovieSchedule();

        try {
            PlaySchedule playSchedule = movie.getPlaySchedules().get(movieSchedule - 1);
            addSelectSchedules(playSchedules, playSchedule);
            return playSchedule;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("범위를 벗어났습니다.");
            return selectSchedule(playSchedules, movie);
        }

    }

    public static Movie selectMovie(List<Movie> movies, List<Movie> selectMovies) {
        selectMovies.clear();
        int movieId = InputView.inputMovieId();
        Movie movie = OutputView.printMovieSchedule(movies, movieId);

        if (movie == null) {
            return selectMovie(movies, selectMovies);
        }

        addSelectMovie(selectMovies, movie);

        return movie;
    }

    public static void addSelectMovie(List<Movie> selectMovies, Movie movie) {
        selectMovies.add(movie);
    }

    public static void addSelectSchedules(List<PlaySchedule> selectSchedule, PlaySchedule playSchedule) {
            selectSchedule.add(playSchedule);
    }

    /* tset */
    public static void printMovie(List<Movie> selectMovies) {
        for (Movie movie : selectMovies) {
            System.out.println(movie);
        }
    }

    public static void printSchedule(List<PlaySchedule> playSchedules) {
        for (PlaySchedule playSchedule : playSchedules) {
            System.out.println(playSchedule);
        }
    }
}
