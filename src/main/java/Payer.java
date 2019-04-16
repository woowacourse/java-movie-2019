import domain.MovieReservation;
import domain.PayDiscount;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Payer {
    public static void pay(List<MovieReservation> reservations) {
        int totalPrice = 0;
        for (MovieReservation r : reservations) {
            totalPrice += r.totalPrice();
        }

        int point = InputView.inputPoint();
        totalPrice -= Integer.min(point, totalPrice);

        PayDiscount payDiscount = InputView.inputPayDiscount();
        OutputView.printTotalPrice(payDiscount.discount(totalPrice));
    }
}
