package domain;

import java.time.LocalDateTime;

public class PurchasedMovie {
    private Movie movie;
    private PlaySchedule playSchedule;
    private int countOfTickets;
    private int money = 0;
    private int totalMoney = 1;

    public PurchasedMovie(Movie movie, PlaySchedule playSchedule, int countOfTickets) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.countOfTickets = countOfTickets;
        money = movie.getPrice() * countOfTickets;
        totalMoney *= money;
    }

    public LocalDateTime getLocalDateTime() {
        return playSchedule.getStartDateTime();
    }
}
