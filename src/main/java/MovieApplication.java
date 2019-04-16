import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        Movie selectedMovie = OutputView.selectMovie(movies, movieId);
        OutputView.printMovie(selectedMovie);
        int scheduleId = InputView.inputScheduleId();
        PlaySchedule selectSchedule = selectedMovie.getPlaySchedule(scheduleId);
//        System.out.println(selectSchedule);
        int reservationCount = InputView.inputReservationCount();
        System.out.println(reservationCount);
    }
}
