package input;

import domain.Movie;
import domain.PlaySchedule;
import domain.ReservedMovie;
import utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleInput {
    private int scheduleId;

    public ScheduleInput(Movie movie, String input, List<ReservedMovie> reservedMovies) {
        if (checkValidity(movie, input, reservedMovies) == false) {
            throw new IllegalStateException();
        }
        scheduleId = convertInputToScheduleId(input);

    }

    public int scheduleIdIs() {
        return scheduleId;
    }

    private int convertInputToScheduleId(String input) {
        int number = Integer.parseInt(input);
        return number - 1;
    }

    private boolean checkValidity(Movie movie, String input, List<ReservedMovie> reservedMovies) {
        int Id = convertInputToScheduleId(input);
        if (checkValidity(movie, Id) == false) {
            return false;
        }
        if (checkValidity(movie, Id, reservedMovies) == false) {
            return false;
        }
        return true;
    }

    private boolean checkValidity(Movie movie, int id, List<ReservedMovie> reservedMovies) {
        LocalDateTime thisOne = movie.getScheduleById(id).dateTimeIs();
        for (ReservedMovie reservedMovie : reservedMovies
             ) {
            LocalDateTime anotherOne = reservedMovie.movieIs().
                    getScheduleById(reservedMovie.getScheduleId()).dateTimeIs();
            if (!DateTimeUtils.isOneHourWithinRange(thisOne, anotherOne)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkValidity(Movie movie, int id) {
        boolean inrange = id < movie.sizeOfScheduleList() && id >= 0;
        return checkValidity(movie.getScheduleById(id));
    }

    private boolean checkValidity(PlaySchedule schedule) {
        LocalDateTime nowTime = LocalDateTime.now();
        if (schedule.dateTimeIs().compareTo(nowTime) < 0) {
            return false;
        }
        return true;
    }

}
