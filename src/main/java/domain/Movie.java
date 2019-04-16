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

    int getId() {
        return this.id;
    }

    int getPrice(){
        return this.price;
    }

    boolean isEqualId(int movieId) {
        return this.id == movieId;
    }

    public List<PlaySchedule> getPlaySchedules() {
        return this.playSchedules;
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

    public String toStringOnlyMovieField(){
        return id + " - " + name + ", " + price + "원" + NEW_LINE;
    }
}
