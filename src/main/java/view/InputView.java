package view;

import domain.Movie;
import input.MovieInput;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ASK_MOVIE_ID = "## 예약할 영화를 선택하세요.";
    private static final String MOVIE_ID_ERROR = "## 영화 리스트에서 존재하는 영화의 ID를 고르셔야" +
            " 합니다.";

    private static final Scanner scanner = new Scanner(System.in);

    public static Movie inputMovie(List<Movie> movies) {
        System.out.println(ASK_MOVIE_ID);
        try {
            MovieInput movieInput = new MovieInput(movies, scanner.nextLine().trim());
            return movieInput.toMovie();
        } catch (Exception e) {
            System.out.println(MOVIE_ID_ERROR);
            return inputMovie(movies);
        }
    }
}
