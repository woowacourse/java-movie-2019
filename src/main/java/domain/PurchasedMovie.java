package domain;

public class PurchasedMovie {
    private Movie movie;
    private PlaySchedule playSchedule;
    private int countOfTickets;

    public PurchasedMovie(Movie movie, PlaySchedule playSchedule, int countOfTickets) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.countOfTickets = countOfTickets;
    }
}
