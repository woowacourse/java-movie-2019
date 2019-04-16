package domain;

public class ReservedMovie {
    private static final char NEW_LINE = '\n';
    private static final String RESERVED_MEMBER_IS = "예약 인원: ";
    private static final String PEOPLE_COUNT = "명";

    private Movie movie;
    private int scheduleId;
    private int memberNumber;

    public ReservedMovie(Movie movie, int scheduleId, int memberNumber) {
        this.movie = movie;
        this.scheduleId = scheduleId;
        this.memberNumber = memberNumber;
    }

    @Override
    public String toString() {
        String string = movie.toStringWithoutPlaySchedule();
        string += movie.getScheduleById(scheduleId).toStringWithoutCapacity();
        string += RESERVED_MEMBER_IS + memberNumber + PEOPLE_COUNT;

        return super.toString();
    }
}
