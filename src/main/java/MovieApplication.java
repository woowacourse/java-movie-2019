import domain.Movie;
import domain.MovieRepository;
import utils.MovieFunc;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<Movie> movReservation = new ArrayList<>();
        // 여기서부터 반복반복... movies는 동일하게 가야함.(주석 삭제 요망)
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId(movies);
        int movieSch = InputView.inputMovieSch(MovieFunc.getMovieSameId(movieId,movies), movReservation); //movieid인 movie 가져오기.
        // TODO 구현 진행
    }
}
