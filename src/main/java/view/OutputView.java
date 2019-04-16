package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        System.out.println("## 상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static Movie selectMovie(List<Movie> movies, int movieId) throws Exception {
        for (Movie movie : movies) {
            if (movie.isThisMovie(movieId)) {
                return movie; // TODO: 차후에 depth를 1칸 줄인다.
            }
        }
        throw new Exception("상영목록에 없는 영화를 선택하셨습니다.");
    }
}
