import java.util.HashSet;
import java.util.List;

import view.ErrorMessage;
import view.InputView;
import view.OutputView;
import domain.Movie;
import domain.MovieRepository;

public class MovieApplication {
    static HashSet<Integer> useableMovieNumberList;

    static void init() {
        useableMovieNumberList = new HashSet<>();
        useableMovieNumberList.add(1);
        useableMovieNumberList.add(5);
        useableMovieNumberList.add(7);
        useableMovieNumberList.add(8);
    }
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printList();
        OutputView.printMovies(movies);

        // TODO 구현 진행
        init();
        selectMovie();

    }

    static void selectMovie() {
        int movieId = 0;
        do {
            movieId = InputView.inputMovieId();
        } while (checkUseableMovie(movieId));

        Movie movie = MovieRepository.getSelectedMovieInformation(movieId);
        OutputView.printMovie(movie);
    }

    static boolean checkUseableMovie(int num) {
        if (!useableMovieNumberList.contains(num)) {
            System.out.println(ErrorMessage.errorMessage.get("ERROR_USEABLEMOVIE"));
            return true;
        }
        return false;
    }

}
