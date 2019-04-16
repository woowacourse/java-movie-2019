package domain;

import java.time.LocalDateTime;

public class Reservation {
    private Movie movie;
    private LocalDateTime scheduleTime;
    private int peopleNum;

    public Reservation(Movie movie, int schedule, int peopleNum) {
        this.movie = movie;
        this.scheduleTime = movie.getPlaySchedule(schedule).getStartDateTime();
        this.peopleNum = peopleNum;
    }

    public LocalDateTime getScheduleTime() {
        return scheduleTime;
    }

    public int getTotal() {
        return movie.getPrice() * peopleNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(movie.getInformation());
        sb.append("시작시간: " + scheduleTime + "\n");
        sb.append("예약 인원: " + peopleNum + "명\n");

        return sb.toString();
    }
}
