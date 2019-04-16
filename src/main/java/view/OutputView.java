package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovie(Movie movie){
        System.out.println(movie);
    }

    public static void printMisMatchInputType(){
        System.out.println("유효하지 않은 입력값입니다.");
    }
    public static void printNotExistMovie(int movieId){
        System.out.println("영화번호 2번은" + movieId + "번은 없는 영화 번호입니다.");
    }

    public static void printNotExistSchedule(int scheduleNumber){
        System.out.println(scheduleNumber + "번 시간은 없는 시간표입니다.");
    }
}
