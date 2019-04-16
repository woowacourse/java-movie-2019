package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }

    public int getId() { return id; }

    public Optional<PlaySchedule> getScheduleByNumber(int no) {
        if ((1 <= no) && (no <= playSchedules.size())) {
            return Optional.of(playSchedules.get(no - 1));
        }
        return null;
    }

    public int getPrice() { return price; }
}