import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {

    public ReservateInformation ExecuteAppBeforeGoback() {
        Movie userMovie = InputView.inputMovieId();

        OutputView.printMovie(userMovie);

        PlaySchedule reserveSchedule = InputView.inputReserveTime(userMovie);
        ReservePeople reservePeople = InputView.inputReservePeople(reserveSchedule);

        PaymentOrReservation paymentOrReservationObject = InputView.inputPaymentOrReservation();
        int paymentOrReservation = paymentOrReservationObject.getPaymentOrReservation();
        ReservateInformation reservateInformation = new ReservateInformation(reserveSchedule, userMovie, reservePeople);
        isGoback(paymentOrReservation);
        return reservateInformation;
    }

    private void ExecuteAppAfterGoback(ReservateInformation reservateInformation) {

        OutputView.printReservateInfo(reservateInformation);
        Point point = InputView.inputPoint(reservateInformation);
        CardOrCash cardOrCash = InputView.inputCardOrCash();
        

    }

    private void isGoback(int paymentOrReservation) {
        if (paymentOrReservation == 2) {
            ReservateMovie();
            return;
        }
    }

    public void ReservateMovie() {

        OutputView.printMovies();
        ReservateInformation reservateInformation = ExecuteAppBeforeGoback();
        ExecuteAppAfterGoback(reservateInformation);
    }

    public static void main(String[] args) {
        MovieApplication movieApplication = new MovieApplication();
        movieApplication.ReservateMovie();
        // TODO 구현 진행
    }
}
