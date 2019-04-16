package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static utils.DateTimeUtils.format;

public class Reservation {
    private static final char NEW_LINE = '\n';
    private final int id;
    private final String name;
    private final int price;
    private LocalDateTime playSchedule;
    private final int number;

    public Reservation(int id, String name, int price, LocalDateTime playSchedule, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.playSchedule = playSchedule;
        this.number = number;
    }

    public LocalDateTime getPlaySchedule() {
        return playSchedule;
    }

    @Override
    public String toString() {
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + "시작시간: " + format(playSchedule) + NEW_LINE + "예약 인원: " + number + NEW_LINE;
    }
}
