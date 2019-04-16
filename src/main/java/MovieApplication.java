import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {


    public static void printSelectMovie(int movieId) {
        Movie temp = MovieRepository.getSelectMovies(movieId);
        if (temp == null) {
            System.out.println("해당 영화가 없습니다.");
        } else {
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        System.out.println("##상영 영화 목록");
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        printSelectMovie(movieId);
        // TODO 구현 진행
    }


}


