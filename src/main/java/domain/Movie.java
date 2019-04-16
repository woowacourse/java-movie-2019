package domain;

import java.time.LocalDateTime;
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

    public String movieTimeInformation(int movieScheduleNumber) {
        int index = getIndexForScheduleNumber(movieScheduleNumber);

        return playSchedules.get(index).playTimeInformation();
    }

    public boolean matchMovieId(int movieId) {
        return id == movieId;
    }

    public boolean matchMovieTime(int movieScheduleNumber) {
        int index = getIndexForScheduleNumber(movieScheduleNumber);
        if ( (index < 0) || (index > playSchedules.size()-1)
                || playSchedules.get(index).matchCurrentTime()) {
            return false;
        }
        return true;
    }

    public boolean mathPlaySchedule(PlaySchedule playSchedule, int movieScheduleNumber) {
        int index = getIndexForScheduleNumber(movieScheduleNumber);

        return playSchedules.get(index).matchSchedule(playSchedule.getStartDateTime());
    }

    public boolean matchMovieCapacity(int movieScheduleNumber, int capacity) {
        int index = getIndexForScheduleNumber(movieScheduleNumber);
        return playSchedules.get(index).matchCapacity(capacity);
    }

    public int getPrice() {
        return price;
    }

    private int getIndexForScheduleNumber(int scheduleNumber){
        return scheduleNumber - 1;
    }

    public PlaySchedule getPlayScheduleOfIndex(int movieScheduleNumber) {
        int index = getIndexForScheduleNumber(movieScheduleNumber);
        return playSchedules.get(index);
    }
}
