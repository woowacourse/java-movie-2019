package view;

import domain.Movie;
import domain.ReservedMovie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printReservedMovies(List<ReservedMovie> reservedMovies){
        for (ReservedMovie reservedMovie : reservedMovies) {
            System.out.println(reservedMovie);
        }
    }

    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }

    public static void printMisMatchInputType() {
        System.out.println("유효하지 않은 입력값입니다.");
    }

    public static void printNotExistMovie(int movieId) {
        System.out.println("영화번호 2번은" + movieId + "번은 없는 영화 번호입니다.");
    }

    public static void printNotExistSchedule(int scheduleNumber) {
        System.out.println(scheduleNumber + "번 시간은 없는 시간표입니다.");
    }

    public static void printOverlapMovieTime(){
        System.out.println("현재 예약하려는 영화와 1시간 이상 상영시간 차이가 나는 영화가 있습니다. 다시 예매해주세요");
    }

    public static void printOverTimeMovieTime(){
        System.out.println("현재 예약하려는 영화가 이미 상영되었습니다. 다시 예매해주세요.");
    }

    public static void printContinueError(){
        System.out.println("결제를 진행하려면 1번, 추가 예약을 하시려면 2번을 입력하셔야합니다.");
    }
}
