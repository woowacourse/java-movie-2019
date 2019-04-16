import domain.Basket;
import domain.Booking;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    private static List<Movie> movies = MovieRepository.getMovies();
    private static Basket basket = new Basket();

    public static void main(String[] args) {
        Booking booking = bookMovie();
    }

    private static Booking bookMovie() {
        try {
            OutputView.printMovies(movies);
            Movie selectedMovie = selectMovie();
            OutputView.printPlaySchedule(selectedMovie);

            int selectedPlaySchedule = InputView.selectPlaySchedule();
            int numberOfPeople = InputView.inputNumberOfPeople();
            return new Booking(selectedMovie, selectedPlaySchedule, numberOfPeople);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return bookMovie();
        }
    }

    private static Movie selectMovie() {
        try {
            int movieId = InputView.inputMovieId();
            return getMovie(movieId);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return selectMovie();
        }
    }

    private static Movie getMovie(int movieId) throws Exception {
        for (Movie movie : movies)
            if (movie.isIdSelected(movieId)) return movie;
        throw new Exception("선택하신 번호의 영화가 없습니다. 다시 입력해주세요.");
    }
}
