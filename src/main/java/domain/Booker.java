package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Booker {
    private List<Movie> bookingMovies;
    private List<Integer> bookingTime;
    private List<Integer> bookingNumber;

    private int tryBookingNumber = 0;

    public Booker() {
        bookingMovies = new ArrayList<>();
        bookingTime = new ArrayList<>();
        bookingNumber = new ArrayList<>();
    }

    public void selectMovie() {
        bookingMovies.add(MovieRepository.getMovie(InputView.inputMovieId()));
    }

    public void selectBookingTime() {
        bookingTime.add(InputView.inputBookingTime(bookingMovies.get(tryBookingNumber)));
    }

    public void selectBookingNumber(){
        bookingNumber.add(InputView.inputBookingNumber(bookingMovies.get(tryBookingNumber),bookingTime.get(0)));
    }
    
    public int currentBookingMovieId(){
        return bookingMovies.get(tryBookingNumber).getId();
    }
}
