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
        while(true) {
            if(ReserveMovie.assertMovieId(movies, movieId) == true) {
                OutputView.printInputMovieSchedule(movies, movieId);
                break;
            }
            System.out.println("상영 목록에 없는 영화를 선택하셨습니다. 예매가 불가능합니다. 다시 선택해주세요.\n");
            movieId = InputView.inputMovieId();
        }

        //int movieSchedule = InputView.inputMovieSchedule();

        //int movieWatchPeople = InputView.inputMovieWatchPeople();


        // TODO 구현 진행
    }
}
