package domain;

import utils.DateTimeUtils;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.List;

public class MovieValidator {

    public static boolean isExistMovie(int movieId) {
        return MovieRepository.getMovie(movieId) == null;
    }

    public static boolean scheduleValidate(List<ReservedMovie> reservedMovies, PlaySchedule schedule) {
        if (schedule.getStartDateTime().isBefore(LocalDateTime.now())) {
            OutputView.printOverTimeMovieTime();
            return false;
        }
        for (ReservedMovie reservedMovie : reservedMovies) {
            if (!DateTimeUtils.isOneHourWithinRange(schedule.getStartDateTime(), reservedMovie.getStartDateTime())) {
                OutputView.printOverlapMovieTime();
                return false;
            }
        }
        return true;
    }

    public static boolean isValidContinueInput(int continueCheck){
        if (continueCheck > 2 || continueCheck < 1){
            OutputView.printContinueError();
            return false;
        }
        return true;
    }
}
