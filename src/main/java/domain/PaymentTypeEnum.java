package domain;

public enum PaymentTypeEnum {
    CARD(1, 0.05),
    CASH(2, 0.02);

    private int code;
    private double discountRate;

    PaymentTypeEnum(int code, double discountRate) {
        this.code = code;
        this.discountRate = discountRate;
    }

    public static PaymentTypeEnum getValue(int code) {
        for (PaymentTypeEnum paymentTypeEnum : values()) {
            if (paymentTypeEnum.code == code) {
                return paymentTypeEnum;
            }
        }
        throw new IllegalArgumentException(code + "는 유효하지 않은 값입니다.");
    }

    public double getDiscountRate() {
        return 1 - discountRate;
    }
}
