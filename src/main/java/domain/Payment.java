package domain;

import java.util.List;
import view.InputView;
import view.OutputView;

public class Payment {
    private List<Reservation> reservations;
    private int totalMoney = 0;
    private int usingPoints;
    private double discountRate;

    public Payment(List<Reservation> reservations) {
        this.reservations = reservations;
        for (Reservation reserv : reservations) {
            totalMoney += reserv.getPaymentAmount();
        }
        System.out.println(totalMoney);
        OutputView.printPaymentStart();
        usingPoints = InputView.inputPaymentPoint();
        totalMoney -= usingPoints;
        discountRate = getDiscountRate();
        totalMoney = (int) ((double) totalMoney - ((double) totalMoney * discountRate));
        OutputView.printPaymentFinished(totalMoney);
    }

    private static double getDiscountRate() {
        int paymentMethod = InputView.inputPaymentMethod();
        if (paymentMethod == 1) { // 신용카드
            return 0.05;
        }
        if (paymentMethod == 2) { // 현금
            return 0.02;
        } // 시간이 급해서 임시방편
        System.out.println("결제 유형이 잘못 입력되었습니다.");
        return getDiscountRate();
    }
}
