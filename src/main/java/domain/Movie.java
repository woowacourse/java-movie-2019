package domain;

import java.util.ArrayList;
import java.util.List;

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

    public String toString(boolean simple) {
        return id + " - " + name + ", " + price + "원" + NEW_LINE;
    }

    public PlaySchedule getSchedule(int time) {
        return playSchedules.get(time - 1);
    }
//예외 처리 할것

    public boolean idCheak(int index) {
        if (index == this.id) {
            return true;
        }
        return false;
    }

    public int getPrice() {
        return this.price;
    }
}
