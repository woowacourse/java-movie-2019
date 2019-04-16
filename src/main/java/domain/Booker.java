package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Booker {
    private List<Movie> bookingMovies;
    private List<Integer> bookingTime;
    private List<Integer> bookingNumber;

    private int trybookingNumber = 0;

    public Booker() {
        bookingMovies = new ArrayList<>();
        bookingTime = new ArrayList<>();
        bookingNumber = new ArrayList<>();
    }

    public void selectMovie(int movieId) {
        bookingMovies.add(MovieRepository.getMovie(movieId));
    }

    public void selectBookingTime() {
        bookingTime.add(InputView.inputBookingTime(bookingMovies.get(trybookingNumber)));
    }

    public void selectBookingNumber(){
        bookingNumber.add(InputView.inputBookingNumber(bookingMovies.get(trybookingNumber),bookingTime.get(0)));
    }
}
