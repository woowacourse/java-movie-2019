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

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ReservationInputValidator inputValidator = new ReservationInputValidator();
        List<Integer> movieNumbers = inputValidator.getReservationMovieNumbers(line);
        ReservationPlanner reservationPlanner = new ReservationPlanner();
        for (Integer movieNumber : movieNumbers) {
            reservationPlanner.displayMovieSchedule(movieNumber);
            Integer movieEntry = scanner.nextInt();
            Integer capacity = scanner.nextInt();
            reservationPlanner.selectReservationEntry(movieNumber, movieEntry);
            reservationPlanner.selectReservationCapacity(movieNumber, movieEntry, capacity);
        }
        reservationPlanner.getPlans().forEach(System.out::println);
    }
}
