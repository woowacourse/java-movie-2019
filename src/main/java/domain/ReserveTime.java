package domain;

import java.util.List;

public class ReserveTime {
    private final PlaySchedule reserveSchedule;

    public ReserveTime(Movie movie, int reserveTime) {
        List<PlaySchedule> playScheduleList = movie.getPlaySchedules();
        if (!(reserveTime <= playScheduleList.size() && reserveTime > 0)) {
            throw new IllegalArgumentException("올바른 예매 시간을 입력해 주세요.");
        }
        this.reserveSchedule = playScheduleList.get(reserveTime-1);
    }

    public PlaySchedule getReserveSchedule() {
        return reserveSchedule;
    }
}
