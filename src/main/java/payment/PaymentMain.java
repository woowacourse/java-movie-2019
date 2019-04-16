package payment;

import domain.ResultPay;
import reservation.MovieReservation;
import view.InputView;
import view.OutputView;

public class PaymentMain {
    public static void paymentrun(MovieReservation reservations){
        OutputView.PaymentStart();
        ResultPay resultPay;
        int point = InputView.InputPoint();
        int pay = reservations.getPay();
        resultPay = new ResultPay(pay,point);
    }
}
