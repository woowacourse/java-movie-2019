import domain.MovieReservation;
import domain.Payment;
import view.InputView;
import view.OutputView;

public class MovieApplication {
    public static void main(String[] args) {
        MovieReservation movieReservation = new MovieReservation();
        movieReservation.reservationMovie();
        int totalPrice = movieReservation.totalPrice();
        OutputView.printPaymentBegin();
        Payment payment = new Payment(totalPrice);
        payment.addPoint();
        payment.howToPay();
        OutputView.printTotalPrice(payment.caculateFinalPrice());
        InputView.closeInputView();
    }
}
