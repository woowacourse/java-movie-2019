package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';
    private static final int ONE = 1;

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

    public boolean isRightMovie(int movieId) {
        return (id == movieId);
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

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return price;
    }

    public List<PlaySchedule> getPlaySchedules() {
        return playSchedules;
    }

    public void checkTimeScheduleValid(int timeScheduleIndex) {
        playSchedules.get(timeScheduleIndex - ONE);
        if (checkMovieSchedule(timeScheduleIndex - ONE)) {
            throw new IllegalArgumentException("이미 지난 시간표입니다");
        }
    }

    public boolean isMoviePossible() {
        return playSchedules.stream()
                .anyMatch(schedule -> schedule.isSchedulePossible());
    }

    public boolean checkMovieSchedule(int timeScheduleIndex) {
        return playSchedules.get(timeScheduleIndex).isSchedulePossible();
    }
}
