package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    public String movieInfo() {
        return id + " - " + name + ", " + price + "원";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return movieInfo() + NEW_LINE + sb.toString();
    }

    int getId() {
        return id;
    }

    int getPrice() {
        return price;
    }

    public PlaySchedule getPlaySchedules(int time) {
        return playSchedules.get(time);
    }
}
