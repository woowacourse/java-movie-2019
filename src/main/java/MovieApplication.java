import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {

    Reservation reservation;
    static List<Movie> movies = MovieRepository.getMovies();


    public static void main(String[] args) {

        OutputView.printMovies(movies);
        int movieId = InputView.inputMovieId();
        Movie chooseMovie = MovieRepository.getMovie(movieId);
        OutputView.printMovie(chooseMovie);
        int scheduleNumber = InputView.inputScheduleNumber();
        int reservationPersonnel = InputView.inputReservationPersonnel();

        InputView.goPaymentOrAddReservation();

        OutputView.printSchedule(chooseMovie, scheduleNumber);

        // TODO 구현 진행
    }
}
