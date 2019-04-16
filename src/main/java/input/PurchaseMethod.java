package input;

public enum PurchaseMethod {
    CREDIT_CARD(0.05),
    CASH(0.02);

    private double discountRate;

    PurchaseMethod(double discountRate) {
        this.discountRate = discountRate;
    }

    public PurchaseMethod getValueOf(String input) {
        if (checkValidity(input) == false) {
            throw new IllegalArgumentException();
        }
        if (input.equals("1")) {
            return CREDIT_CARD;
        }
        return CASH;
    }

    private boolean checkValidity(String input) {
        if(input.equals("1") || input.equals(("2"))) {
            return true;
        }
        return false;
    }

    public double showDiscountRate() {
        return discountRate;
    }

}
