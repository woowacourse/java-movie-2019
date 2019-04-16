package domain;

import java.util.List;

public class Payment {
    private final static double CARD_DISCOUNT = 0.05;
    private final static double CASH_DISCOUNT = 0.02;

    private List<UserSelection> userSelections;

    private int point;

    public Payment(List<UserSelection> userSelections, int point) {
        this.userSelections = userSelections;
        this.point = point;
    }

    public int getFinalPrice(boolean cardOrCash) {
        int finalPrice = 0;

        for (UserSelection userSelection : userSelections)
            finalPrice += userSelection.getPrice();

        finalPrice = finalPrice - this.point;

        finalPrice = (cardOrCash) ? (int) (finalPrice - finalPrice * CARD_DISCOUNT) : (int) (finalPrice - finalPrice * CASH_DISCOUNT);

        return finalPrice;
    }
}
