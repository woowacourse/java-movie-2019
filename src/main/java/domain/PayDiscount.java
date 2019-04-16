package domain;

public enum PayDiscount {
    CARD(1, 5), MONEY(2, 2), NOT_EXIST(-1, 0);

    private final int command;
    private final int discountPercent;

    PayDiscount(int command, int discountPercent) {
        this.command = command;
        this.discountPercent = discountPercent;
    }

    public static PayDiscount valueOf(int command) {
        for (PayDiscount discount : values()) {
            if (discount.command == command) {
                return discount;
            }
        }
        return NOT_EXIST;
    }

    public int discount(int price) {
        int r = price / 100;
        return price - (discountPercent * r);
    }
}
