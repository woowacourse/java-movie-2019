import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {

    public void ReservateMovie(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Movie userMovie = InputView.inputMovieId();
        OutputView.printMovie(userMovie);
        PlaySchedule reserveSchedule = InputView.inputReserveTime(userMovie);
        InputView.inputReservePeople(reserveSchedule);
        int paymentOrReservation = InputView.inputPaymentOrReservation();
        if(paymentOrReservation == 2){
            ReservateMovie();
        }
    }
    public static void main(String[] args) {
        MovieApplication movieApplication = new MovieApplication();
        movieApplication.ReservateMovie();
        // TODO 구현 진행
    }
}
