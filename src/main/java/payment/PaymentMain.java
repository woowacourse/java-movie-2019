package payment;

import domain.ResultPay;
import reservation.MovieReservation;
import view.InputView;
import view.OutputView;

public class PaymentMain {
    public static void paymentrun(MovieReservation reservations) {
        OutputView.PaymentStart();
        ResultPay resultPay;
        int point = InputView.InputPoint();
        int pay = reservations.getPay();
        int paymentMethod = InputView.selectPaymentMethod();
        resultPay = new ResultPay(pay, point, paymentMethod);
        resultPay.printResult();
    }
}
