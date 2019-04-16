package domain;

import java.time.LocalDateTime;

public class PurchasedMovie {
    private Movie movie;
    private PlaySchedule playSchedule;
    private int countOfTickets;
    private static int totalTickets = 0;

    public PurchasedMovie(Movie movie, PlaySchedule playSchedule, int countOfTickets) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.countOfTickets = countOfTickets;
        totalTickets += countOfTickets;
    }

    public LocalDateTime getLocalDateTime() {
        return playSchedule.getStartDateTime();
    }
}
