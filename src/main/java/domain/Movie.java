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

    public String toString(int tableId) {
        return id + " - " + name + ", " + price + "원" + NEW_LINE + playSchedules.get(tableId).toStringForConfirm();
    }

    public boolean isSameMovieId(int id) {
        return this.id == id;
    }

    public boolean makeReserve(int movieTable, int numPeople) {
        if (playSchedules.get(movieTable).makeReserve(numPeople))
            return true;
        return false;
    }

    public int getPrice() {
        return price;
    }

    public PlaySchedule getSchedule(int tableId) {
        return playSchedules.get(tableId);
    }
}
