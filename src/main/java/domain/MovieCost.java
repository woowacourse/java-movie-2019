package domain;

import java.util.List;

public class MovieCost {
    private final static double CREDIT_DISCOUNT_RATE = 0.05;
    private final static double CASH_DISCOUNT_RATE = 0.02;

    private int cost;

    public MovieCost(Reservation reservation, int isCredit, int point) {
        Movie movie = reservation.getMovie();
        int count  = reservation.getBuyCount();

        cost = movie.getPrice() * count;
    }

    public int getCost() {
        return cost;
    }
}
