package domain;

import java.util.List;

public class AllPay {
    private final static double CREDIT_DISCOUNT = 0.95;
    private final static double CASH_DISCOUNT = 0.98;

    private List<MovieCost> movieCosts;

    public AllPay(List<MovieCost> movieCosts) {
        this.movieCosts = movieCosts;
    }

    public int getTotalCost(int point, int isCredit) {
        if (isCredit == 1) {
            return (int) ((getTotalMovieCost() * CREDIT_DISCOUNT) - point);
        }
        return (int) ((getTotalMovieCost() * CASH_DISCOUNT) - point);
    }

    private int getTotalMovieCost() {
        int sum = 0;
        for (MovieCost cost : movieCosts) {
            sum += cost.getCost();
        }
        return sum;
    }



}
