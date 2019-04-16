package validator;

import domain.Movie;

public class ScheduleValidator implements Validator {

    private final Movie movie;
    private final String scheduleNum;

    public ScheduleValidator(Movie movie, String scheduleNum) {
        this.movie = movie;
        this.scheduleNum = scheduleNum;
    }

    @Override
    public boolean doesValid() {
        return doesScheduleInputIsValid()
                && doesPlaySchedulesExist();
    }

    public boolean doesScheduleInputIsValid() {
        MovieInputValidator movieInputValidator = new MovieInputValidator(scheduleNum);
        return movieInputValidator.doesValid();
    }

    public boolean doesPlaySchedulesExist() {
        return movie.doesPlaySchedulesHas(Integer.parseInt(scheduleNum));
    }
}
