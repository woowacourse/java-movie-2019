package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';
    private static final int MIN_SCHEDULE_IDX = 0;

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

    public boolean isSameId(int id) {
        return (this.id == id);
    }

    public boolean containsPlayScheduleIdx(int playScheduleIdx) {
        return ((playScheduleIdx >= MIN_SCHEDULE_IDX) && (playScheduleIdx < playSchedules.size()));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public PlaySchedule getPlayScheduleByIdx(int idx) {
        return playSchedules.get(idx);
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
}
