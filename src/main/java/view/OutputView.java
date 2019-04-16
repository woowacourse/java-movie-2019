package view;

import domain.Movie;
import domain.PlaySchedule;

import java.util.List;

/**
 * 출력 값을 관리하는 객체
 *
 * @version 1.0(2019.04.16)
 * @author jongyoon Kim
 */
public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovieInfo(Movie movie){
        System.out.println(movie);
    }
}
