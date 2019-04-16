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

    public boolean movieMatchOf(int id){
        return (this.id == id);
    }

    public PlaySchedule checkSchedue(int scheduleId, int people) {
        if(scheduleId > playSchedules.size()){
            throw new IllegalArgumentException("## 시간표가 맞지 않습니다.");
        }

        if(playSchedules.get(scheduleId).checkCapacity(people)){
            throw new IllegalArgumentException("## 매진 입니다.");
        }


        return playSchedules.get(scheduleId);
    }

}
