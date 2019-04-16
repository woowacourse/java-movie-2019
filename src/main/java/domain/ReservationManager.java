package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class ReservationManager {
    private static final String POINT_ERROR_MENT = "마일리지가 구매금액보다 큽니다.";

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
        payReservation();
    }

    private void payReservation() {
        int userPoint = InputView.inputPoint();
        int totalReservationPrice = reservationMovieList.getTotalReservationPrice();
        InputView.inputPaymentMethod();
        try{
            checkPointValidate(userPoint, totalReservationPrice);
        } catch (Exception e){
            throw new IllegalArgumentException(POINT_ERROR_MENT);
        }
        OutputView.printEndReservation(totalReservationPrice - userPoint);
    }

    private void checkPointValidate(int userPoint, int totalReservationPrice) {
        if (userPoint > totalReservationPrice) {
            throw new IllegalArgumentException();
        }
    }
}
