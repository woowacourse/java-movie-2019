import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.PurchasedMovie;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<PurchasedMovie> purchasedMovies = new ArrayList<>();
        HashMap<Integer, Integer> IdMap = new HashMap<>();
        IdMap.put(1, 0);
        IdMap.put(5, 1);
        IdMap.put(7, 2);
        IdMap.put(8, 3);

        OutputView.printMovies(movies);

        int movieId;
        int countOfTickets;
        int scheduleNumber;
        boolean continueBooking = true; //추가 예약 여부

        while (continueBooking) {
            movieId = IdMap.get(InputView.inputMovieId());
            OutputView.printMovies(movies, movieId);
            scheduleNumber = InputView.inputMovieSchedule(movies, movieId, purchasedMovies) - 1;
            countOfTickets = InputView.inputCountOfTickets(movies, movieId, scheduleNumber);
            movies.get(movieId).buyTickets(scheduleNumber, countOfTickets);
            continueBooking = InputView.inputContinueBooking();

            PlaySchedule playSchedule = movies.get(movieId).getSchedule(scheduleNumber);
            PurchasedMovie purchasedMovie = new PurchasedMovie(movies.get(movieId), playSchedule, countOfTickets);
            purchasedMovies.add(purchasedMovie);
        }


    }
}
