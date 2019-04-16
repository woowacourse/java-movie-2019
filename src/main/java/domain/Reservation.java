package domain;

import java.time.LocalDateTime;

/**
 * 예매 한 번의 내용 역할을 하는 클래스
 */
public class Reservation {
    private Movie movie;
    private int scheduleId;
    private int personnels;

    public Reservation(Movie movie, int scheduleId, int personnels) {
        this.movie = movie;
        this.scheduleId = scheduleId;
        this.personnels = personnels;
    }

    @Override
    public String toString() {
        return movie.toStringWithoutSchedules() + movie.getSchedule(scheduleId).toStringWithoutCapacity() + "예약 인원: " + personnels + "명\n";
    }

    public int howMuch() {
        return movie.getPrice() * personnels;
    }

    public LocalDateTime getDate() { return movie.getSchedule(scheduleId).getDate(); }
}
