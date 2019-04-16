package domain;

import view.InputView;

public class Reservation {
    private SelectedMovie selectedMovie;
    private int totalPrice;
    private int point;

    public Reservation(SelectedMovie selectedMovie){
        this.selectedMovie = selectedMovie;
    }

    public void reservationStatistics(){
        InputView.inputContinueReservation();
        selectedMovie.showSelectedMovieSchecule();
    }

    private void calculateTotalPrice(){
        point = InputView.inputPoint();
        totalPrice = selectedMovie.showPrice();
        totalPrice -= point;
    }
}
