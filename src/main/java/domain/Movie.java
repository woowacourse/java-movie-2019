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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

    public List<PlaySchedule> getSchedules() {
        return playSchedules;
    }

    public PlaySchedule getScheduleInfo(int num) {
        return playSchedules.get(num - 1);
    }

    public int getScheduleSize() {
        return playSchedules.size();
    }

//    public boolean isMovieInTime(int num){
//        playSchedules.get(num-1);
//    }

    public int getCapacity(int movieTime) {
        return playSchedules.get(movieTime - 1).getCapacity();
    }
}
