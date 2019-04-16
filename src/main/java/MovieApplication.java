import domain.Movie;
import domain.MovieRepository;
import domain.MovieValidator;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class MovieApplication {

    private static final int NOT_EXIST_NUMBER = -1;

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        Movie reserveMovie = getReserveMovie(movies, true);
        OutputView.printMovie(reserveMovie);
        PlaySchedule reserveSchedule = getValidSchedule(reserveMovie);
        int reserveAmount = getReserveAmount(reserveSchedule);
    }

    private static int getValidMovieId(List<Movie> movies){
        OutputView.printMovies(movies);
        try {
            int movieId = InputView.inputMovieId();
            return movieId;
        } catch (InputMismatchException e){
            OutputView.printMisMatchInputType();
            InputView.makeLine();
            return getValidMovieId(movies);
        }
    }

    private static Movie getReserveMovie(List<Movie> movies, boolean isFirst){
        int validMovieId = NOT_EXIST_NUMBER;
        do {
            if (!isFirst){
                OutputView.printNotExistMovie(validMovieId);
            }
            validMovieId = getValidMovieId(movies);
            isFirst = false;
        } while (MovieValidator.isExistMovie(validMovieId));
        return MovieRepository.getMovie(validMovieId);
    }

    private static PlaySchedule getValidSchedule(Movie movie){
        int scheduleNumber = NOT_EXIST_NUMBER;
        try {
            scheduleNumber = InputView.inputScheduleNumber();
            return movie.getPlaySchedule(scheduleNumber);
        } catch (IndexOutOfBoundsException e) {
            OutputView.printNotExistSchedule(scheduleNumber);
            return getValidSchedule(movie);
        }
    }

    private static int getReserveAmount(PlaySchedule schedule){
        int reserveAmount = NOT_EXIST_NUMBER;
        do {
            reserveAmount = InputView.inputReserveNumber();
        } while (!schedule.isPossibleReserve(reserveAmount));
        schedule.reserve(reserveAmount);
        return reserveAmount;
    }
}
