import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        Reservation reserv1 = new Reservation(movies);
        System.out.println(reserv1);
    }
}
