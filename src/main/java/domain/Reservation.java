package domain;

public class Reservation {
    private MovieId moiveId;
    private ScheduleNumber scheduleNumber;
    private NumberOfPeople numberOfpeople;

    public Reservation(MovieId movieId, ScheduleNumber scheduleNumber,
                       NumberOfPeople numberOfPeople) {
        this.moiveId = movieId;
        this.scheduleNumber = scheduleNumber;
        this.numberOfpeople = numberOfPeople;
    }
}
