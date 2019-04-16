package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class ReservationCategory {
    private static final char NEW_LINE = '\n';

    private final Movie movie;

    private final LocalDateTime startDateTime;
    private final int numberOfPerson;

    public ReservationCategory(Movie movie, LocalDateTime startDateTime, int numberOfPerson){
        this.movie = movie;
        this.startDateTime = startDateTime;
        this.numberOfPerson = numberOfPerson;
    }

    @Override
    public String toString() {
        return movie.getId() + " - " + movie.getName() + ", " + movie.getPrice() + "원" + NEW_LINE
                + "시작시간: " + format(startDateTime) + NEW_LINE
                + "예약인원: " + numberOfPerson + NEW_LINE;
    }

    public int reservedPrice(){
        return (movie.getPrice() * numberOfPerson);
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

}
