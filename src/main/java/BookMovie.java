import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BookMovie {
    List<Movie> movies;

    public BookMovie(){
        movies = MovieRepository.getMovies();
        showMovieList();
    }

    private void showMovieList(){
        OutputView.printMovies(movies);
    }

    public Movie getSelectedMovie() {
        int movieId = InputView.inputMovieId();
        for (Movie m : movies){
            if (m.getMovieId() == movieId){
                return m;
            }
        }
        throw new IllegalArgumentException("해당하는 영화가 없습니다.");
    }
}
