package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';
    private static final int START_NUMBER = -1;

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

    public boolean matchId(int movieId){
        return (this.id == movieId) ? true : false;
    }

    public void printSchedule(int scheduleNo){
        System.out.println(playSchedules.get(scheduleNo + START_NUMBER));
    }

    public PlaySchedule getSchedule(int scheduleNo){
        return playSchedules.get(scheduleNo + START_NUMBER);
    }

    public int getSchedulesCount(){
        return playSchedules.size();
    }

    public boolean modifyScheduleCapacity(int scheduleNo, int personnel){
        if(playSchedules.get(scheduleNo+START_NUMBER).isValidCapacity(personnel)){
            return true;
        }
        return false;
    }

    public int getPrice(){
        return this.price;
    }

    public String printMovie(){
        return id + " - " + name + ", " + price + "원" + NEW_LINE;
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
