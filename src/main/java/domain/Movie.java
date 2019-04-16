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

    public int getId(){
        return id;
    }

    public int getSchSize(){
        return playSchedules.size();
    }

    public LocalDateTime getSchStartTime(int sch){
        return playSchedules.get(sch).getStartDateTime();
    }

    public List<PlaySchedule> getPlaySchedules() {
        return playSchedules;
    }

    public boolean isCapacityNotZero(int sch){
        return playSchedules.get(sch).isCapacityNotZero();
    }

    public boolean isInnerCapacity(int sch, int capa){
        return playSchedules.get(sch).isInnerCapacity(capa);
    }

    public void DecCapacity(int sch, int capa){
        playSchedules.get(sch).decCapacity(capa);
    }
}
