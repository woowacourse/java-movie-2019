package validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;

public class ScheduleValidator implements Validator {

    private static final String delimiter = ":";

    private final Map<String, String> schedules;     // Movie, schedule

    public ScheduleValidator(List<String> schedule) {
        this.schedules = new HashMap<>();
        for (String s : schedule) {
            String[] movieAndSchedule = splitByDelimeter(s);
            insertMovieAndSchedule(movieAndSchedule);
        }
    }

    @Override
    public boolean doesValid() {
        return doesMovieAndScheduleInputIsValid()
                && doesMovieAndPlaySchedulesExist()
                && doesEachScheduleAreOneHourWithinRange();
    }

    private boolean doesMovieAndScheduleInputIsValid() {
        List<String> movieList = new ArrayList<>(schedules.keySet());
        List<String> scheduleList = new ArrayList<>(schedules.values());

        return doesInputIsValid(movieList) && doesInputIsValid(scheduleList);
    }

    private boolean doesInputIsValid(List<String> inputs) {
        return !inputs.stream()
                .map(MovieInputValidator::new)
                .noneMatch((movieInputValidator) -> movieInputValidator.doesValid());
    }

    private boolean doesMovieAndPlaySchedulesExist() {
        return !schedules.entrySet().stream()
                .anyMatch((movieAndSchedule) -> {
                    int movieId = Integer.parseInt(movieAndSchedule.getKey());
                    int schedule = Integer.parseInt(movieAndSchedule.getValue());
                    Movie movie = MovieRepository.getMovieById(movieId);
                    if (movie == null) {
                        return false;
                    }
                    return !movie.doesPlaySchedulesHas(schedule);
                });
    }

    private void insertMovieAndSchedule(String[] movieAndSchedule) {
        schedules.put(movieAndSchedule[0], movieAndSchedule[1]);     // TODO 입력값이 1:1 등이 아닐 때 예외 처리할 것
    }

    private boolean doesEachScheduleAreOneHourWithinRange() {
        return !schedules.entrySet().stream()
                .anyMatch((movieAndSchedule) -> {
                    int movieId = Integer.parseInt(movieAndSchedule.getKey());
                    int schedule = Integer.parseInt(movieAndSchedule.getValue());
                    Movie movie = MovieRepository.getMovieById(movieId);
                    PlaySchedule playSchedule = movie.getScheduleByIndex(schedule);
                    return !doesScheduleAreOneHourWithinRange(playSchedule);         // 하나의 스케쥴을 가지고 전체 스케쥴과 비교
                });
    }

    private boolean doesScheduleAreOneHourWithinRange(PlaySchedule playSchedule1) {
        return !schedules.entrySet().stream()
                .anyMatch((movieAndSchedule) -> {
                    int movieId = Integer.parseInt(movieAndSchedule.getKey());
                    int schedule = Integer.parseInt(movieAndSchedule.getValue());
                    Movie movie = MovieRepository.getMovieById(movieId);
                    PlaySchedule playSchedule2 = movie.getScheduleByIndex(schedule);
                    return !playSchedule1.isOneHourWithinRange(playSchedule2);
                });
    }

    private String[] splitByDelimeter(String input) {
        return input.split(delimiter);
    }
}
