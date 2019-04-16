package input;

import domain.Movie;
import domain.PlaySchedule;

import java.time.LocalDateTime;

public class ScheduleInput {
    private int scheduleId;

    public ScheduleInput(Movie movie, String input) {
        if (checkValidity(movie, input) == false) {
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

    private boolean checkValidity(Movie movie, String input) {
        int Id = convertInputToScheduleId(input);
        if (checkValidity(movie, Id) == false) {
            return false;
        }
        return true;
    }

    private boolean checkValidity(Movie movie, int id) {
        boolean inrange = id < movie.sizeOfScheduleList() && id >= 0;
        return checkValidity(movie.getScheduleById(id));
    }

    private boolean checkValidity(PlaySchedule schedule) {
        LocalDateTime nowTime = LocalDateTime.now();
        if (schedule.dateTimeIs().compareTo(nowTime) == -1) {
            return false;
        }
        return true;
    }

}
