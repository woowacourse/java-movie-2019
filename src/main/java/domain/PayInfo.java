/*
 * @(#)PayInfo.java
 *
 * v 0.0.0
 *
 * 2019.04.16
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package domain;

/**
 * 결제 정보를 담는 클래스
 *
 * @version 0.0.0
 * @author kwonmc
 */
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
