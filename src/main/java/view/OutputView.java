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

    public static void printNoMovieMessage() {
        System.out.println("현재 상영하지 않는 영화입니다. 다시 입력해주시기 바랍니다.");
    }

    public static void printNoScheduleMessage() {
        System.out.println("상영하지 않는 시간입니다. 다시 입력해주시기 바랍니다.");
    }

    public static void printNotEnoughCapacityMessage() {
        System.out.println("관람 정원 초과입니다. 다시 입력해주시기 바랍니다.");
    }

    public static void printAlreadyStartedMessage() {
        System.out.println("이미 상영이 시작된 영화입니다. 다시 입력해주시기 바랍니다.");
    }
}
