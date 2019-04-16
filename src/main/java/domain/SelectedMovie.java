package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class SelectedMovie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;
    private final LocalDateTime startDateTime;
    private int people;

    public SelectedMovie(int id, String name, int price, LocalDateTime startDateTime, int people) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.startDateTime = startDateTime;
        this.people = people;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public int getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + "시작시간: " + format(startDateTime) + NEW_LINE
                + "예약 인원: " + people + "명";
    }
} 
