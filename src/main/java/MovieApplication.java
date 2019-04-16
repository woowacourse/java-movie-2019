import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<Reservation> reservations = new ArrayList<>();
        int reservContinue = 2;
        while (reservContinue == 2) {
            reservations.add(new Reservation(movies));
            reservContinue = InputView.inputReservationContinue();
        }
        for (Reservation reserv : reservations) {
            System.out.println(reserv);
        }
        OutputView.printMovies(movies);
    }
}
