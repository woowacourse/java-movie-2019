import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import reservation.MovieReservation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        MovieReservation reservations = new MovieReservation();
        PlaySchedule schedule;

        OutputView.printMovies(movies);
        int movieId = InputView.inputMovieId();
        Movie selectedMovie = OutputView.printPlaySchedule(movieId);
        do{
             schedule = InputView.inputPlaySchedule(selectedMovie);
        } while(!reservations.checkVaildSchedule(schedule));
    }
}
