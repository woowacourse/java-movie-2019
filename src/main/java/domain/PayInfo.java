package domain;

public class PayInfo {
    private int pointAmount;
    private int payType;

    public PayInfo(int pointAmount, int payType) {
        this.pointAmount = pointAmount;
        this.payType = payType;
    }

    private boolean isCard() {
        return (this.payType == 1);
    }

    private double discountRate(boolean isCard) {
        return isCard ? 0.05 : 0.02;
    }

    public int getTotalPriceApplyPayInfo(ReservationList reservationList) {
        int totalPrice = reservationList.getTotalPrice();
        int afterUsingPoint = totalPrice - this.pointAmount;
        double applyDiscountRate = 1 - discountRate(isCard());
        return (int) (afterUsingPoint * applyDiscountRate);
    }
}
