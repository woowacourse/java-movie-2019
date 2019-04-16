package domain;

import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.List;

public class Payment {

    public int pay(List<PaymentInfo> paymentInfos) throws IOException {
        OutputView.printPayments(paymentInfos);
        int point = InputView.inputPoint();
        double discountRate = cashOrCredit();

        return (int) ((totalMoney(paymentInfos) - point) * discountRate);
    }

    private int totalMoney(List<PaymentInfo> paymentInfos) {
        int total = 0;
        for (PaymentInfo paymentInfo : paymentInfos) {
            total += paymentInfo.getMovie().getPrice() * paymentInfo.getCountOfUser();
        }
        return total;
    }

    private double cashOrCredit() throws IOException {
        int cashOrCredit = InputView.cashOrCredit();
        if (cashOrCredit == 1) {
            return 0.95;
        }
        if (cashOrCredit == 2) {
            return 0.98;
        }
        return -1;
    }
}
