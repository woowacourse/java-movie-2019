package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void notExistedMovie() {
        System.out.println("※ 상영목록에 해당 영화는 존재하지 않습니다. 다시 선택해주세요.");
    }
}
