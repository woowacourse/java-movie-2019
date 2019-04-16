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

    // 같은 영화가 맞는지
    public boolean isSameMovie(int movieNumber){
        return id == movieNumber;
    }

    // 공석이 있는지
    public boolean vacancyExist(){
        return playSchedules.stream().anyMatch(schedule -> schedule.isNotEmpty());
    }
    // 해당 스캐줄이 존재하는지
    public boolean isScheduleExist(int scheduleIndex){
        return (playSchedules.size()-1 >= scheduleIndex);
    }
    // 스캐줄 가져오기
    public PlaySchedule getSchedule(int indexIndex){
        return playSchedules.get(indexIndex);
    }
}
