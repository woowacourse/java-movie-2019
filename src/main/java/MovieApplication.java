import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.List;

import static utils.DateTimeUtils.format;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        int movieIndex;
        while(true) {
            movieIndex = ReserveMovie.assertMovieId(movies, movieId);
            if(movieIndex != -1) {
                OutputView.printInputMovieSchedule(movies, movieIndex);
                break;
            }
            OutputView.printImpossibleReasonSelectedMovieNotOnTheList();
            movieId = InputView.inputMovieId();
        }

        int movieSchedule = InputView.inputMovieSchedule();
        while(true) {
            if(ReserveMovie.assertMovieSchedule(movies, movieIndex, movieSchedule)) {
                System.out.println();
                break;
            }
            OutputView.printImpossibleReasonSelectedMovieAlreadyStartTime();
            movieSchedule = InputView.inputMovieSchedule();
        }

        int movieWatchPeople = InputView.inputMovieWatchPeople();
        while(true) {
            if(ReserveMovie.assertMovieWatchPeople(movies, movieIndex, movieSchedule, movieWatchPeople)) {
                System.out.println();
                break;
            }
            OutputView.printImpossibleReasonWatchPeopleExceeding();
            movieWatchPeople = InputView.inputMovieWatchPeople();
        }


        ReserveMovie.addReserveMovie(movies.get(movieIndex), movieSchedule, movieWatchPeople);




        // TODO 구현 진행
    }
}
