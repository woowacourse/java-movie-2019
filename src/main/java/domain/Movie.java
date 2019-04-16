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

    public int getPrice() {
        return price;
    }

    public boolean isSmallerPlayScheduleSize(int size) {
        return (size >= playSchedules.size());
    }

    public boolean isMatchMovieID(int movieID) {
        return (id == movieID);
    }

    public String selectedMovieInfo(int startTime, int numberOfPeople) {
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + playSchedules.get(startTime - 1).getStartTime()
                + "예약 인원: " + numberOfPeople + "명" + NEW_LINE;
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
