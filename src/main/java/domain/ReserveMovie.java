package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;


public class ReserveMovie {
    private List<Reservation> reservationList = new ArrayList<>();

    public ReserveMovie() {

    }

    public void reserve() {
        int movieId = InputView.inputMovieId();
        int movieTime = InputView.inputMovieTime();
        int movieTicket = InputView.inputMovietickets();
        reservationList.add(new Reservation(movieId, movieTime, movieTicket));
    }

}
