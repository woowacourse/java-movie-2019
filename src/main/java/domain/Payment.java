package domain;

import view.InputView;
import view.OutputView;

public class Payment {
    private Point point;
    private PaymentWay paymentWay;
    private int totalPrice;

    public Payment(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addPointAndChoosePayMethod() {
        addPoint();
        howToPay();
    }

    private void addPoint() {
        try {
            point = new Point(InputView.inputPoint());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            addPoint();
        }
    }

    private void howToPay() {
        try {
            paymentWay = new PaymentWay(InputView.inputPaymentWay());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            howToPay();
        }
    }

    public int calculateFinalPrice() {
        totalPrice = point.discountAmount(totalPrice);
        totalPrice = paymentWay.discountPrice(totalPrice);
        return totalPrice;
    }
}
