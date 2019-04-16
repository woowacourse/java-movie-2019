package managers;

import domain.Movie;
import domain.MovieRepository;
import domain.ReservationRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ReservationManager {
    public static void makeReservation() {
        printMovieList();
        InputView.inputMovieId();
        InputView.inputScheduleNo();
        InputView.inputNumToReserve();
    }

    private static void printMovieList() {
        System.out.println("## 상영 영화 목록");
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    public static void printReservationList() {
        List<Movie> movies = ReservationRepository.getList();
        OutputView.printMovies(movies);
    }


}
