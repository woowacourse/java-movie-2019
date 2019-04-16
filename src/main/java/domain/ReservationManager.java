package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class ReservationManager {
    private ReservationMovieList reservationMovieList = ReservationMovieList.getInstance();

    public void initReservation() {
        OutputView.printMovies(MovieRepository.getMovies());
        startReserve();
    }

    public void startReserve() {
        int movieId = InputView.inputMovieId();
        OutputView.printSelectedMovie(movieId);

        int movieTime = InputView.inputMovieTime();
        int movieNumberOfPeople = InputView.inputNumberOfPeople();

        MovieRepository.reserveMovie(movieId, movieTime, movieNumberOfPeople);
        reservationMovieList.addReservationMovie(new ReservationMovie(MovieRepository.getSelectedMovie(movieId), movieTime, movieNumberOfPeople));
        askContinueReservation();
    }

    public void askContinueReservation() {
        int payOrReserve = InputView.inputPayOrReserve();
        OutputView.printReservation();
        if (payOrReserve == 2) {
            initReservation();
            return;
        }
    }
}
