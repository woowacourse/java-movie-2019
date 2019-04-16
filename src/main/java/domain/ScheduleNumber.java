package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScheduleNumber {
    private final int START_NUMBER = 1;
    private final int scheduleNumber;

    private boolean isValid(int movieId, int scheduleNumber) {
        Optional<Movie> matchResult = MovieRepository.getMovies().stream()
                .filter(movie -> movie.getId() == movieId).findAny();
        Movie movie = matchResult.get();

        return movie.contains(scheduleNumber);
    }

    public ScheduleNumber(int movieId, int scheduleNumber) {
        if (!isValid(movieId, scheduleNumber)
                || (scheduleNumber < START_NUMBER)) {
            System.out.println("상형 시간 목록에 있는 시간을 골라주세요.");
            throw new IllegalArgumentException();
        }
        this.scheduleNumber = scheduleNumber;
    }
}
