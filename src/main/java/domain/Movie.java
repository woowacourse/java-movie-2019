package domain;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;

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

    public String getMovieInfo(){
        return id + " - " + name + ", " + price + "원" + NEW_LINE;
    }

    public int getMovieId(){
        return id;
    }

    public int getPrice(){
        return price;
    }

    public PlaySchedule getPlaySchedule(int playScheduleId) {
        return playSchedules.get(playScheduleId-1);
    }

    public boolean isNotStartedMovie(int playScheduleId){
        return LocalDateTime.now().isBefore(getPlaySchedule(playScheduleId).getStartDateTime());
    }
}
