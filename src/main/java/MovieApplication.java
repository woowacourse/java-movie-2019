import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MovieApplication {

    private static final int NOT_EXIST_NUMBER = -1;

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<ReservedMovie> reservedMovies = new ArrayList<>();
        int check = 2;
        while (check == 2) {
            Movie reserveMovie = getReserveMovie(movies);
            OutputView.printMovie(reserveMovie);
            PlaySchedule reserveSchedule = getValidSchedule(reservedMovies, reserveMovie);
            if (reserveSchedule == null) {
                continue;
            }
            int reserveAmount = getReserveAmount(reserveSchedule);
            reservedMovies.add(new ReservedMovie(reserveMovie,
                    reserveSchedule.getStartDateTime(), reserveAmount));
        }
    }

    private static int getValidMovieId(List<Movie> movies) {
        OutputView.printMovies(movies);
        try {
            int movieId = InputView.inputMovieId();
            return movieId;
        } catch (InputMismatchException e) {
            OutputView.printMisMatchInputType();
            InputView.makeLine();
            return getValidMovieId(movies);
        }
    }

    private static Movie getReserveMovie(List<Movie> movies) {
        int validMovieId = NOT_EXIST_NUMBER;
        boolean isFirst = true;
        do {
            if (!isFirst) {
                OutputView.printNotExistMovie(validMovieId);
            }
            validMovieId = getValidMovieId(movies);
            isFirst = false;
        } while (MovieValidator.isExistMovie(validMovieId));
        return MovieRepository.getMovie(validMovieId);
    }

    private static PlaySchedule getValidSchedule
            (List<ReservedMovie> reservedMovies, Movie movie) {
        int scheduleNumber = NOT_EXIST_NUMBER;
        try {
            scheduleNumber = InputView.inputScheduleNumber();
            PlaySchedule schedule = movie.getPlaySchedule(scheduleNumber);
            if (!MovieValidator.isOneHourWithinOtherReservedMovie(reservedMovies, schedule)){
                return null;
            }
            return schedule;
        } catch (IndexOutOfBoundsException e) {
            OutputView.printNotExistSchedule(scheduleNumber);
            return getValidSchedule(reservedMovies, movie);
        }
    }

    private static int getReserveAmount(PlaySchedule schedule) {
        int reserveAmount = NOT_EXIST_NUMBER;
        do {
            reserveAmount = InputView.inputReserveNumber();
        } while (!schedule.isPossibleReserve(reserveAmount));
        schedule.reserve(reserveAmount);
        return reserveAmount;
    }
}
