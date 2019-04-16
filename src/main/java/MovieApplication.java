import domain.Movie;
import domain.MovieRepository;
import domain.ReservedMovie;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        MovieApplication application = new MovieApplication();
        application.reserveMovie();
        InputView.inputContinueOrPay();
    }

    private void reserveMovie() {
        String dummyName = "생일";
        int dummyPrice = 8_000;

        try {
            int movieId = InputView.inputMovieId();
            int movieSchedule = InputView.inputMovieSchedule();
            int headcount = InputView.inputHeadcount();
            ReservedMovie reservedMovie = new ReservedMovie(movieId,
                dummyName, dummyPrice, movieSchedule, headcount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            reserveMovie();
        }
    }
}
