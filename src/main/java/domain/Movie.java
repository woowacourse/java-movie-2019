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

    public String movieInformation() {
        return id + " - " + name + ", " + price + "원";
    }

    public String movieTimeInformation(int time) {
        return playSchedules.get(time).playTimeInformation();
    }

    public boolean matchMovieId(int movieId) {
        return id == movieId;
    }

    public boolean matchMovieTime(int movieTime) {
        if (movieTime < 1 || movieTime > playSchedules.size()) {
            return false;
        }
        return true;
    }

    public boolean matchMovieCapacity(int movieTime, int capacity) {
        return playSchedules.get(movieTime).matchCapacity(capacity);
    }
}
