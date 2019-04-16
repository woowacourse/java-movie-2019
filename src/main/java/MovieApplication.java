import domain.Movie;
import domain.MovieRepository;
import domain.ReservationInputValidator;
import domain.ReservationPlanner;
import java.util.List;
import java.util.Scanner;
import view.OutputView;

public class MovieApplication {

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        ReservationInputValidator inputValidator = new ReservationInputValidator();
        List<Integer> movieNumbers = inputValidator.getReservationMovieNumbers();
        ReservationPlanner reservationPlanner = new ReservationPlanner();
        Scanner scanner = new Scanner(System.in);
        for (Integer movieNumber : movieNumbers) {
            reservationPlanner.displayMovieSchedule(movieNumber);
            Integer movieEntry = scanner.nextInt();
            Integer capacity = scanner.nextInt();
            reservationPlanner.selectReservationEntry(movieNumber, movieEntry);
            reservationPlanner.selectReservationCapacity(movieNumber, movieEntry, capacity);
        }
    }
}
