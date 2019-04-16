import domain.Movie;
import domain.MovieRepository;
import service.MovieReservation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        MovieReservation movieReservation = new MovieReservation();
        movieReservation.run();
    }
}
