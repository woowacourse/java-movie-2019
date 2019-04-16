package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovieInfo(String movie) {
        System.out.println(movie);
    }

    public static void printMoviePayState(String movie, String movieTime, int people) {
        System.out.println(movie);
        System.out.println(movieTime);
        System.out.println("예약 인원 : " + people + "명\n");
    }

    public static void printResult(int totalPrice, int point, double pay) {
        double double_result = (totalPrice - point) * pay;
        int result = (int) double_result;
        System.out.println("\n최종 결제한 금액은 " + result + "원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }

    public static void printIdException() {
        System.out.println("해당 영화가 없습니다.");
        System.out.println("다시 입력해 주세요.");
    }

    public static void printTImeException() {
        System.out.println("상영 시간이 아닙니다.");
        System.out.println("다시 입력해 주세요.");
    }

    public static void printExitException() {
        System.out.println("1번 또는 2번만 입력해주세요.");
        System.out.println("다시 입력해 주세요.");
    }

    public static void printPointException() {
        System.out.println("0 미만은 잘못된 포인트 값 입니다.");
        System.out.println("다시 입력해 주세요.!");
    }

    public static void printPeopleException() {
        System.out.println("자리가 부족합니다.");
        System.out.println("다시 입력해 주세요.");
    }
}
