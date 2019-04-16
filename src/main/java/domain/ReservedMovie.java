package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class ReservedMovie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;
    private final LocalDateTime startDateTime;
    private final int peopleToReserve;

    public ReservedMovie(Movie movie, PlaySchedule playSchedule, int peopleToReserve) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.price = movie.getPrice();
        this.startDateTime = playSchedule.getStartDateTime();
        this.peopleToReserve = peopleToReserve;
    }

    @Override
    public String toString() {
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + "시작시간: " + format(startDateTime) + NEW_LINE
                + "예약 인원: " + peopleToReserve + NEW_LINE;
    }
}
