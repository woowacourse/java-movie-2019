package domain;


import utils.DateTimeUtils;

public class Booking {
    public final Movie movie;
    public final PlaySchedule schedule;
    public final int numOfPeople;

    public Booking(Movie movie, PlaySchedule schedule, int numOfPeople) {
        this.movie = movie;
        this.schedule = schedule;
        this.numOfPeople = numOfPeople;
    }

    @Override
    public String toString() {
        return String.format(
            "%s\n예약시간: %s\n예약 인원: %d명",
            movie.toString(),
            DateTimeUtils.format(schedule.getStartDateTime()),
            numOfPeople
        );
    }
}
