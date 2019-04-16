import domain.Movie;
import domain.MovieRepository;
import domain.ReservedInfo;
import utils.MovieConstants;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
        public static void main(String[] args) {
                List<Movie> movies = MovieRepository.getMovies();
                OutputView.printMovies(movies);
                int payOrAdd;
                do {
                        int movieId = InputView.inputMovieId();
                        OutputView.printSelectedMovie(movieId);

                        int schedule = InputView.inputMovieSchedule(movieId);

                        int people = InputView.inputMoviePeople(movieId, schedule);
                        ReservedInfo.addInfo(movieId, schedule, people);
                } while (InputView.inputPayOrAdd() == MovieConstants.selectAddReservation);
                OutputView.printReservationInfo();
        }
}
