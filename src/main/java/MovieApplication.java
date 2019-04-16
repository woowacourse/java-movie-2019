import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.ReservationMovie;
import jdk.internal.util.xml.impl.Input;
import reservation.MovieReservation;
import reservation.ReservationMain;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        MovieReservation reservations = new MovieReservation();
        do{
            OutputView.printMovies(movies);
            ReservationMain.reservationRun(reservations);
            reservations.printResult();
        } while(InputView.InputContinueReservation());
    }
}
