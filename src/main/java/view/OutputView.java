package view;

import domain.Movie;
import domain.SelectMovie;

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

    public static void printSelectedMovie(Movie movie){
        System.out.println(movie);
    }

    public static void printNotInMovieTime(){
        System.out.println("예약 가능한 시간대의 영화번호를 선택해 주세요");
    }

    public static void printNotInPeopleNum(){
        System.out.println("0에서 가능한 예약 가능 인원 이내의 숫자를 입력해 주세요.");
    }

    public static void printNotZeroOne(){
        System.out.println("0 혹은 1을 입력해 주세요.");
    }

    public static void printTicketHistory(List<SelectMovie> movies){
        for (SelectMovie movie : movies) {
            System.out.println(movie);
        }
    }

}
