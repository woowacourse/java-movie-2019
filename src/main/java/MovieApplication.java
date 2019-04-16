import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static int getMovieId(int number){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);
        numbers.add(7);
        numbers.add(8);
        return numbers.indexOf(number);
    }

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = getMovieId(InputView.inputMovieId());

        // TODO 구현 진행
        String sellectMovie = movies.get(movieId).toString();
        System.out.println(sellectMovie);
    }

}
