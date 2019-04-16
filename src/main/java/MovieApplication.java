import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {

    static List<Reservation> reservations = new ArrayList<Reservation>();
    static List<Movie> movies = MovieRepository.getMovies();


    public static void main(String[] args) throws IOException {
        boolean flag = true;
        while(flag){
            flag = reservationOneCycle();
        }
        payment();
        // TODO 구현 진행
    }

    private static boolean reservationOneCycle() throws IOException{
        OutputView.printMovies(movies);
        int movieId = InputView.inputMovieId();
        Movie chooseMovie = MovieRepository.getMovie(movieId);
        OutputView.printMovie(chooseMovie);
        int scheduleNumber = InputView.inputScheduleNumber();
        int reservationPersonnel = InputView.inputReservationPersonnel();
        try {
            reservations.add(new Reservation(chooseMovie, reservationPersonnel, scheduleNumber));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return InputView.goPaymentOrAddReservation();
    }

    private static void payment(){

    }
}
