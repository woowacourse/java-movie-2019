import domain.Movie;
import domain.MovieRepository;
import domain.Payment;
import domain.SelectedMovie;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.List;

import static utils.DateTimeUtils.format;

public class MovieApplication {
    public static void main(String[] args) {
        final int EXIT_RESERVATION = 1;
        final int ADD_RESERVATION = 2;
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        while(true) {
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

            /*
            while(true) {
                if(ReserveMovie.assertMovieScheduleWithinRange(movies, movieIndex, movieSchedule)) {
                    System.out.println();
                    break;
                }
                // 다시
                OutputView.printImpossibleReasonSelectedMovieAlreadyStartTime();
                movieSchedule = InputView.inputMovieSchedule();
            }
            */
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
                    ReserveMovie.addReserveMovie(movies.get(movieIndex), movieSchedule, movieWatchPeople);
                    break;
                }
                OutputView.printImpossibleReasonWatchPeopleExceeding();
                movieWatchPeople = InputView.inputMovieWatchPeople();
            }

            int exitOrAddReserve = InputView.inputExitOrAddReservation();
            if (exitOrAddReserve == EXIT_RESERVATION) {
                System.out.println();
                OutputView.printSelectedMovies(ReserveMovie.getSelectedMovies());
                break;
            }

            System.out.println();
        }

        OutputView.printPayment();
        int usingPoints = InputView.inputUsingPoints();

        int inputCardOrCash = InputView.inputCardOrCash();
        //OutputView.printnew Payment(ReserveMovie.getSelectedMovies(), usingPoints, inputCardOrCash).getMoney();
    }
}
