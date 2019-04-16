import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservationMachine;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        MovieReservationMachine.showAvailableMovies();
    }
}
