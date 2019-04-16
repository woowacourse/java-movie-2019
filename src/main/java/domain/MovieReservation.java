package domain;

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
                + movie.getScheduleInfo(scheduleId) + NEW_LINE
                + "예약 인원 : " + reservationNumber + "명";
    }
}
