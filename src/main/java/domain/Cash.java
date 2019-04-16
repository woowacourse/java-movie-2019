package domain;

public class Cash {
    public static final double DISCOUNT_RATE = 0.02;

    public int getDiscountedPrice(int money) {
        return (int) (money * (1 - DISCOUNT_RATE));
    }
}
