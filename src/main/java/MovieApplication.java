import domain.Movie;
import domain.MovieRepository;
import domain.ReservationRepository;
import enumerations.Action;
import managers.PaymentManager;
import managers.ReservationManager;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        while(true) {
            ReservationManager.makeReservation();
            if(InputView.inputAction() == Action.PAYMENT.getNum()){
                ReservationManager.printReservationList();
                break;
            }
        }
        PaymentManager.makePayment();
    }
}
