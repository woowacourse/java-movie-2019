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
        return (int)((totalPrice - this.pointAmount) * discountRate(isCard()));
    }
}
