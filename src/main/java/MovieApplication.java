import domain.Movie;
import domain.MovieRepository;
import domain.ScheduledMovie;
import view.InputView;
import view.OutputView;

import java.sql.SQLSyntaxErrorException;
import java.util.LinkedList;
import java.util.List;

public class MovieApplication {

    static List<Movie> books = new LinkedList<>();

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        Movie movie = check(movies);
        OutputView.printEachMovie(movie);

    }

    public static Movie check(List<Movie> movies){
        try{
            int movieId = InputView.inputMovieId();
            return findMovie(movies,movieId);
        }catch(IllegalArgumentException e){
            return check(movies);
        }
    }

    public static Movie findMovie(List<Movie> movies, int id){
        for(Movie each : movies){
            if(each.movieMatchOf(id)){
                books.add(each);
                return each;
            }
        }

        throw new IllegalArgumentException("없는 영화표를 선택하셨습니다.");
    }


}