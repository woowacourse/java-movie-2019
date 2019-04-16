import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        int movieId = 0;
        
        try {
            movieId = InputView.inputMovieId();
            System.out.println(movies.get(movieId));
        } catch (IndexOutOfBoundsException e) {
        	System.out.println("0 ~ 4 사이의 영화를 선택하세요.");
        	movieId = InputView.inputMovieId();
        }
        
        int movieTime = InputView.inputMovieTime();
        System.out.println(movies.get(movieId).getPlayMovieSchedule(movieTime - 1));
    }
}
