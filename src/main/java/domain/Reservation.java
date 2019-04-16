package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
}
