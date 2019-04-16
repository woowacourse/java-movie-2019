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

    public static void showSelectedMovie(int id) {
        if (id <= 0 || id > MovieRepository.getMoivesSize()) {
            System.out.println("숫자 범위를 넘어갔습니다. 유효한 숫자를 입력해주세요.");
            return;
        }
        System.out.println(MovieRepository.getMovie(id));
    }
}
