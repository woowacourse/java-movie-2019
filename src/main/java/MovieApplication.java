import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {

    public void ReservateMovie(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Movie userMovie = InputView.inputMovieId();
        OutputView.printMovie(userMovie);
        PlaySchedule reserveSchedule = InputView.inputReserveTime(userMovie);
        ReservePeople reservePeople = InputView.inputReservePeople(reserveSchedule);
        PaymentOrReservation paymentOrReservationObject = InputView.inputPaymentOrReservation();
        int paymentOrReservation = paymentOrReservationObject.getPaymentOrReservation();

        if(paymentOrReservation == 2){
            ReservateMovie();
            return;
        }

        ReservateInformation reservateInformation = new ReservateInformation(reserveSchedule,userMovie,reservePeople);
        OutputView.printReservateInfo(reservateInformation);
        InputView.inputPoint();


    }
    public static void main(String[] args) {
        MovieApplication movieApplication = new MovieApplication();
        movieApplication.ReservateMovie();
        // TODO 구현 진행
    }
}
