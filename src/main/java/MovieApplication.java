import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        int moviePlaySchedule = InputView.inputMoviePlaySchedule(MovieRepository.getMovie(movieId));
        int peopleNumberOfResrvation = InputView.inputPeopleNumberOfReservation(
                MovieRepository.getMovie(movieId).getPlaySchedule(moviePlaySchedule));

        
        int endOrAddReservation = InputView.inputEndOrAddReservation();
        int amountOfPointToUse = InputView.inputAmountOfPointToUse();
        int paymentMethod = InputView.inputPaymentMethod();



    }
}
