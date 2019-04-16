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
        Movie userMovie = InputView.inputMovieId();
        OutputView.printMovie(userMovie);

        PlaySchedule reserveSchedule = InputView.inputReserveTime(userMovie);
        InputView.intputReservePeople(reserveSchedule);
        // TODO 구현 진행
    }
}
