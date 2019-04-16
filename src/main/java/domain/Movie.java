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

    public boolean matchWithId(int id) {
        return this.id == id;
    }

    public PlaySchedule getScheduleByNum(int scheduleNo) {
        int index = scheduleNo-1;
        if(index<0 || index>=playSchedules.size())
            throw new IllegalArgumentException("올바른 스케줄 번호를 입력해주세요.");
        PlaySchedule playSchedule = playSchedules.get(index);
        if(playSchedule.isTimePassed())
            throw new IllegalArgumentException("상영 시작 시간이 이미 지났습니다.");
        return playSchedule;
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
