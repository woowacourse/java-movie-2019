import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static List<Movie> reserveMovies;

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        reserveMovies = new ArrayList<>();
        int movieCount = 0;

        while(InputReserveMovie(movies) == false){ };
        OutputView.printMovies(reserveMovies);
    }

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

}
