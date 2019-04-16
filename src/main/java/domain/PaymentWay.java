package domain;

class PaymentWay {
    private static final int CARD = 1;
    private static final int MONEY = 2;

    private final int paymentWay;

    PaymentWay(int paymentWay) {
        if ((paymentWay != CARD) && (paymentWay != MONEY)) {
            throw new IllegalArgumentException("반드시 신용카드(1) 또는 현금(2)을 숫자로 입력하세요!");
        }
        this.paymentWay = paymentWay;
    }

    int discountPrice(int totalPrice) {
        if (paymentWay == CARD) {
            return ((totalPrice * 95) / 100);
        }
        return ((totalPrice * 98) / 100);
    }
}
