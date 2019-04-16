import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;
import receiver.movieNumReceiver;
import java.util.List;
import java.util.Scanner;

public class MovieApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        movieNumReceiver.getMovieNumFromUser(sc);
    }
}
