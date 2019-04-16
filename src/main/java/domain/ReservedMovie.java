package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class ReservedMovie {
    private static final char NEW_LINE = '\n';

    private final Movie reservedMovie;
    private final LocalDateTime startDateTime;
    private final int reserveAmount;

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public ReservedMovie(Movie reservedMovie,
                         LocalDateTime startDateTime,
                         int reserveAmount) {
        this.reservedMovie = reservedMovie;
        this.startDateTime = startDateTime;
        this.reserveAmount = reserveAmount;
    }

    @Override
    public String toString(){
        return reservedMovie.movieInfo() + NEW_LINE +
                "시작시간: " + format(startDateTime) + NEW_LINE +
                "예약 인원: " + reserveAmount + "명";
    }

}
