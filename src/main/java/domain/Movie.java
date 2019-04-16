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

    public int getId(){
        return this.id;
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

    public int getPeopleCount(int timeId){
        timeId--;
        return playSchedules.get(timeId).getCapacity();
    }

    public String getStartTime(int timeId){
        return playSchedules.get(timeId).startTime();
    }

    public int getPrice(){
        return price;
    }

    public int scheduleCnt(){
        return playSchedules.size();
    }

    public String getName(){
        return name;
    }
}

