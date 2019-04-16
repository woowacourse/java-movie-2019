package domain;


public class Booking {
    public final Movie movie;
    public final PlaySchedule schedule;
    public final int numOfPeople;

    public Booking(Movie movie, PlaySchedule schedule, int numOfPeople) {
        this.movie = movie;
        this.schedule = schedule;
        this.numOfPeople = numOfPeople;
    }
}
