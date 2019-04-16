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

    public boolean isContainsMovieId(int movieId) {
        return this.id == movieId;
    }

    boolean isContainsScheduleNumber(int scheduleNumber) {
        return scheduleNumber >= 1 && scheduleNumber <= playSchedules.size();
    }

    boolean isProperReservationCount(int scheduleNumber, int reservationCount) {
        return playSchedules.get(scheduleNumber - 1).isProperReservationCount(reservationCount);
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

    String summaryMessage(int scheduleNumber) {
        return id + " - " + name + ", " + price + "원" + NEW_LINE + playSchedules.get(scheduleNumber - 1).resultMessage();
    }
}
