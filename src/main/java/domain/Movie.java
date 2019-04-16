package domain;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
    public int getMovieId() { return this.id; }

    public LocalDateTime getMovieTime(int TimeNum){
        return playSchedules.get(TimeNum).getStartDateTime();
    }

    public void decideMovieTime(int TimeNum){
        PlaySchedule tmp = playSchedules.get(TimeNum - 1);
        playSchedules.clear();
        playSchedules.add(tmp);
    }

    public int getScheduleCapacity(){
        return playSchedules.get(0).getCapacity();
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
}
