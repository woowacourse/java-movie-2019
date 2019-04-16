package domain;

/**
 * @author delf
 */
public enum Payment {
    CASH(0.02), CARD(0.05);
    private double discountRate;

    Payment(double discountRate) {

        this.discountRate = discountRate;
    }

    public int getDiscountedPrice(UserInfo user, int point) {
        return (int) (user.getPrice() * (1 - discountRate)) - point;
    }
}
