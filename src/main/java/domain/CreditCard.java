package domain;

public class CreditCard {
    public static final double DISCOUNT_RATE = 0.05;

    public int getDiscountedPrice(int money) {
        return (int) (money * (1 - DISCOUNT_RATE));
    }
}
