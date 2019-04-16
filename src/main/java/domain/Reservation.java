package domain;

import view.InputView;

public class Reservation {
    private SelectedMovie selectedMovie;
    private int totalPrice;

    public Reservation(SelectedMovie selectedMovie){
        this.selectedMovie = selectedMovie;
    }

    public void reservationStatistics(){
        InputView.inputContinueReservation();
        selectedMovie.showSelectedMovieSchecule();
    }
}
