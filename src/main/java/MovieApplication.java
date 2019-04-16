import domain.Movie;
import domain.MovieRepository;
import utils.MovieFunc;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    static List<Movie> movies = MovieRepository.getMovies();
    static List<Movie> movReservation = new ArrayList<>();
    public static void main(String[] args) {

        // 여기서부터 반복반복... movies는 동일하게 가야함.(주석 삭제 요망)
        reservationMovie();
        System.out.println("결제진행");
        // TODO 구현 진행
    }

    private static void reservationMovie(){
        OutputView.printMovies(movies);
        int movieId = InputView.inputMovieId(movies);
        Movie selectedMovie = MovieFunc.getMovieSameId(movieId,movies);
        int movieSch = InputView.inputMovieSch(selectedMovie, movReservation); //movieid인 movie 가져오기.
        int capacity = InputView.inputMovieCapacity(selectedMovie, movieSch);
        MovieFunc.DecCapa(selectedMovie,movieSch,capacity);
        if(InputView.isLoopMovie()){
            reservationMovie();
        }
    }
}
