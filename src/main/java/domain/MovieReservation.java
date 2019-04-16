package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

public class MovieReservation {
    private static final char NEW_LINE = '\n';

    private final Movie movie;
    private final int scheduleId;
    private final int reservationNumber;

    public MovieReservation(Movie movie,
                            int scheduleId, int reservationNumber) {
        this.movie = movie;
        this.scheduleId = scheduleId;
        this.reservationNumber = reservationNumber;
    }

    @Override
    public String toString() {
        return movie.getSimpleInfo() + NEW_LINE
                + movie.getSchedule(scheduleId).getSimpleInfo() + NEW_LINE
                + "예약 인원 : " + reservationNumber + "명";
    }

    public boolean isValidTimeGap(PlaySchedule schedule) {
        LocalDateTime reservationTime
                = movie.getSchedule(scheduleId).getStartDateTime();
        LocalDateTime scheduleTime
                = schedule.getStartDateTime();

        if (DateTimeUtils.isOneHourWithinRange(reservationTime, scheduleTime)) {
            return true;
        }
        return false;
    }

    public int getTotalPrice() {
        return movie.getPrice() * reservationNumber;
    }
}
