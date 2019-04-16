package domain;

import java.util.List;

public class AllPay {
    private final static double CREDIT_DISCOUNT = 0.95;
    private final static double CASH_DISCOUNT = 0.98;

    private List<MovieCost> movieCosts;

    public AllPay(List<MovieCost> movieCosts) {
        this.movieCosts = movieCosts;
    }

    public int getTotalCost(int point, OneOrTwoToken isCredit) {
        int ret = calcTotalCost(point, isCredit);
        if (ret >= 0) {
            return ret;
        }
        System.out.println("포인트가 결제금액보다 크므로 0원이 결제되었습니다.");
        return 0;
    }

    private int calcTotalCost(int point, OneOrTwoToken isCredit) {
        if (isCredit.isOne()) {
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
