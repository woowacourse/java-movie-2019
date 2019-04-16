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
        payment.addPointAndChoosePayMethod();
        OutputView.printTotalPrice(payment.calculateFinalPrice());
        InputView.closeInputView();
    }
}
