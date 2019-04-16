package domain;

import utils.DateTimeUtils;
import view.OutputView;

import java.util.List;

public class MovieValidator {

    public static boolean isExistMovie(int movieId) {
        return MovieRepository.getMovie(movieId) == null;
    }

    public static boolean isOneHourWithinOtherReservedMovie
            (List<ReservedMovie> reservedMovies,
             PlaySchedule schedule) {
        for (ReservedMovie reservedMovie : reservedMovies) {
            if (!DateTimeUtils.isOneHourWithinRange
                    (schedule.getStartDateTime(), reservedMovie.getStartDateTime())) {
                OutputView.printOverlapMovieTime();
                return false;
            }
        }
        return true;
    }
}
