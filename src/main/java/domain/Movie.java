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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    boolean contains(int movieId) {
        return this.id == movieId;
    }

    public PlaySchedule checkVaildSchedule(int scheduleId) {
        try {
            return playSchedules.get(scheduleId - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
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

    void reduceCapacity(PlaySchedule schedule, int reservePeopleNum) {
        if (playSchedules.get(playSchedules.indexOf(schedule)).reduce(reservePeopleNum)) {
            playSchedules.remove(playSchedules.indexOf(schedule));
        }
    }
}
