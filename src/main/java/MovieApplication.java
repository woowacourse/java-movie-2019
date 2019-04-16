import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.List;

import static utils.DateTimeUtils.format;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();
        int movieIndex;
        while(true) {
            movieIndex = ReserveMovie.assertMovieId(movies, movieId);
            if(movieIndex != -1) {
                OutputView.printInputMovieSchedule(movies, movieIndex);
                break;
            }
            System.out.println("상영 목록에 없는 영화를 선택하셨습니다. 예매가 불가능합니다. 다시 선택해주세요.\n");
            movieId = InputView.inputMovieId();
        }

        int movieSchedule = InputView.inputMovieSchedule();
        while(true) {
            if(ReserveMovie.assertMovieSchedule(movies.get(movieIndex), movieSchedule)) {
                break;
            }
            System.out.println("상영 시작 시간이 이미 지난 영화를 선택하셨습니다. 예매가 불가능합니다. 다시 선택해주세요.\n");
            movieSchedule = InputView.inputMovieSchedule();
        }

        //int movieWatchPeople = InputView.inputMovieWatchPeople();


        // TODO 구현 진행
    }
}
