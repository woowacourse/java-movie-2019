package domain;

public class PurchasedMovie {
    private Movie movie;
    private PlaySchedule playSchedule;

    public PurchasedMovie(Movie movie, PlaySchedule playSchedule) {
        this.movie = movie;
        this.playSchedule = playSchedule;
    }
}
