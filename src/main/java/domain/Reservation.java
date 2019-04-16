package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

class Reservation {
    private final LocalDateTime startTime;
    private final int price;
    private final int person;

    Reservation(LocalDateTime startTime, int price, int person) {
        this.startTime = startTime;
        this.price = price;
        this.person = person;
    }

    boolean isValidBetweenThisMovie(Movie selctedMovie, int scheduleNumber) {
        return !DateTimeUtils.isOneHourWithinRange(selctedMovie.getStartDateTime(scheduleNumber), startTime);
    }

    int calculatePrice() {
        return (price * person);
    }

}
