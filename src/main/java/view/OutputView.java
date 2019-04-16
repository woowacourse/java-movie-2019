package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printNotNumber (){
        System.out.println("정수를 입력해 주세요.");
    }

    public static void printNotInMovieNum(){
        System.out.println("영화 목록 범위 안의 정수인 숫자를 입력해 주세요.");
    }

    public static void printSelectedMovie(List<Movie> movies, int SelectedNum){
        for (Movie movie : movies) {
            if (movie.getId() == SelectedNum)System.out.println(movie);
        }
    }
}
