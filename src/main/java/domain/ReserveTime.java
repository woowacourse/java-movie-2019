package domain;

import java.util.List;

public class ReserveTime {
    private final int reserveTime;

    public ReserveTime(Movie movie, int reserveTime) {
        List<PlaySchedule> playScheduleList = movie.getPlaySchedules();
        if (!(reserveTime <= playScheduleList.size() && reserveTime > 0)) {
            throw new IllegalArgumentException("올바른 예매 시간을 입력해 주세요.");
        }
        this.reserveTime = reserveTime;
    }
}
