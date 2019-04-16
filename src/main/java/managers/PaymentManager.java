package managers;

import view.InputView;

public class PaymentManager {
    public static void makePayment() {
        System.out.println("\n## 결제를 진행합니다.");
        InputView.inputPointAmountToUse();
        InputView.inputPaymentMethod();
    }
}
