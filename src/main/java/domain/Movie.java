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

    public int getPrice() {
        return price;
    }

    public PlaySchedule getPlaySchedule(int index) {
        return playSchedules.get(index);
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    public boolean isExistedSchedule(int index) {
        return (1 <= index && index <= playSchedules.size());
    }

    public boolean isSameId(int movieId) {
        return movieId == this.id;
    }

    public boolean isCapable(int scheduleNum, int peopleNum) {
        return playSchedules.get(scheduleNum).isCapable(peopleNum);
    }

    public String getInformation() {
        return id + " - " + name + ", " + price + "원" + NEW_LINE;
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
