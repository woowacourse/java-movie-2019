package domain;

import java.util.List;

public class Payment {
    private static final int PAYMENT_OPTION_CREDIT_CARD = 1;
    private static final int PAYMENT_OPTION_CASH = 2;

    private static final double PAYMENT_DISCOUNT_RATE_CREDIT_CARD= 0.05;
    private static final double PAYMENT_DISCOUNT_RATE_CASH= 0.02;
    private static List<SelectedMovie> selectedMovies;
    private int money;
    private int paymentOption;

    public Payment(List<SelectedMovie> selectedMovies, int usingPoints, int paymentOption) {
        this.selectedMovies = selectedMovies;
        this.paymentOption = paymentOption;
        this.money = totalOfPrice(selectedMovies) - usingPoints;
    }

    private int totalOfPrice(List<SelectedMovie> selectedMovies) {
        int totalMoney = 0;
        for(SelectedMovie movie : selectedMovies) {
            totalMoney += movie.getPrice() * movie.getPeople();
        }
        return totalMoney;
    }

    private double discount(int paymentOption) {
        if (paymentOption == PAYMENT_OPTION_CREDIT_CARD)
            return PAYMENT_DISCOUNT_RATE_CREDIT_CARD;
        return PAYMENT_DISCOUNT_RATE_CASH;
    }

    public int getMoney() {
        return (int) (money * (1 - discount(paymentOption))) ;
    }
}
