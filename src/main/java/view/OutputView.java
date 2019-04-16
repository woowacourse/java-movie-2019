package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static Movie printChoiceMovies(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if(movie.getId() == movieId){
                System.out.println(movie);
                return movie;
            }
        }
        return null;
    }

//    private static Movie checkMovieId(Movie movie, int movieId) {
//        if (movie.getId() == movieId) {
//            System.out.println(movie);
//            return movie;
//        } else {
//            System.out.println("상영 목록에 영화가 없습니다. 다시 입력해 주세요.");
//            movieId = InputView.inputMovieId();
//            return checkMovieId(movie, movieId);
//        }
//    }
}
