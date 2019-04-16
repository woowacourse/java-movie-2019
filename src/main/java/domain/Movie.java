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

    void printMovieWithoutSchedule() {
        System.out.print(id + " - " + name + ", "
                + price + "원" + NEW_LINE);
    }

    boolean hasSameId(int movieId) {
        return id == movieId;
    }

    public PlaySchedule getScheduleById(int scheduleId) {
        try {
            return playSchedules.get(scheduleId - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    int getChargeForPeople(int reservedPersonCount) {
        return price * reservedPersonCount;
    }
}
