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

    public String getSimpleInfo() {
        return id + " - " + name + ", " + price + "원";
    }

    public PlaySchedule getSchedule(int scheduleId) {
        return playSchedules.get(scheduleId);
    }

    public boolean isYourId(int movieId) {
        if (id == movieId) {
            return true;
        }
        return false;
    }

    public boolean isValidScheduleIdRange(int scheduleId) {
        if ((1 <= scheduleId) && (scheduleId <= playSchedules.size())) {
            return true;
        }

        System.out.println("입력하신 번호에 해당하는 시간표가 없습니다.");
        return false;
    }

    public boolean isValidScheduleTime(int scheduleId) {
        int INDEX_ADJUST_NUMBER = 1;
        LocalDateTime now = LocalDateTime.now();
        PlaySchedule schedule
                = playSchedules.get(scheduleId - INDEX_ADJUST_NUMBER);

        if (!schedule.isPassedSchedule(now)) {
            return true;
        }

        System.out.println("이미 상영시작시간이 지난 시간표입니다.");
        return false;
    }

    public boolean isValidTimeGap(List<MovieReservation> reservations,
                                  int scheduleId) {
        PlaySchedule schedule = playSchedules.get(scheduleId);

        for (MovieReservation reservation : reservations) {
            reservation.isValidTimeGap(schedule);
        }
    }

    public boolean isValidScheduleId(List<MovieReservation> reservations,
                                     int scheduleId) {
        if (!isValidScheduleIdRange(scheduleId)) {
            return false;
        }
        if (!isValidScheduleTime(scheduleId)) {
            return false;
        }
        if (reservations.size() != 0 && !isValidTimeGap(reservations, scheduleId)) {
            return false;
        }
        return true;
    }

    public boolean isValidReservationNumber(int scheduleId,
                                            int number) {
        PlaySchedule schedule = playSchedules.get(scheduleId);
        return schedule.isCapacityOK(number);
    }
}
