package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

class Reservation {
    private final LocalDateTime startTime;

    Reservation(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    boolean isValidBetweenThisMovie(Movie selctedMovie, int scheduleNumber) {
        return !DateTimeUtils.isOneHourWithinRange(selctedMovie.getStartDateTime(scheduleNumber), startTime);
    }

}
