import domain.Movie;
import domain.MovieRepository;
import domain.MovieValidator;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        Movie reserveMovie = getReserveMovie(movies, true);
        OutputView.printMovie(reserveMovie);
    }

    private static int getValidMovieId(List<Movie> movies){
        OutputView.printMovies(movies);
        try {
            int movieId = InputView.inputMovieId();
            return movieId;
        } catch (InputMismatchException e){
            System.out.println("영화 목록에 있는 영화 번호를 입력하셔야합니다.");
            InputView.makeLine();
            return getValidMovieId(movies);
        }
    }

    private static Movie getReserveMovie(List<Movie> movies, boolean isFirst){
        int validMovieId = -1;
        do {
            if (!isFirst){
                OutputView.isNotExistMovie(validMovieId);
            }
            validMovieId = getValidMovieId(movies);
            isFirst = false;
        } while (MovieValidator.isExistMovie(validMovieId));
        return MovieRepository.getMovie(validMovieId);
    }
}
