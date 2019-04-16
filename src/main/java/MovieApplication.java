import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class MovieApplication {
    private static List<Movie> reserveMovies;
    private static int movieCount = 0;

    private static Boolean InputReserveMovie(List<Movie> movies){
        int movieId = InputView.inputMovieId();
        InputView.fflush();
        if(checkMovieList(movieId, movies) == null) {
            System.out.println("상영목록에 없는 영화입니다. 다시 선택해주세요.");
            return false;
        }
        reserveMovies.add(checkMovieList(movieId, movies));
        return true;
    }

    private static Movie checkMovieList(int movieId, List<Movie> movies){
        for(Movie movie : movies){
            if(movie.getMovieId() == movieId){
                return movie;
            }
        }
        return null;
    }

    private static Boolean InputMovieTime(){
        int reserveTime = InputView.inputTime();
        InputView.fflush();
        if(checkMovieTime(reserveTime) == false){
            System.out.println("상영 시작 시간이 이미 지난 영화입니다. 다시 선택해주세요.");
            return false;
        }
        return true;
    }

    private static Boolean checkMovieTime(int TimeNum){
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime movieTime = reserveMovies.get(movieCount).getMovieTime(TimeNum);

        return currentTime.isBefore(movieTime);
    }


    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        reserveMovies = new ArrayList<>();

        while(InputReserveMovie(movies) == false){ };
        OutputView.printMovies(reserveMovies);

        InputMovieTime();

        int reserveNum = InputView.inputNum();
        InputView.fflush();
    }

}
