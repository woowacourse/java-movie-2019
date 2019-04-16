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

    public static void printIntervalTooLongMessage() {
        System.out.println("여러 영화를 예매하려는 경우 1시간 이내의 간격이여야 합니다. 다시 입력해주시기 바랍니다.");
    }

    public static void printInvalidCommandMessage() {
        System.out.println("1번(결제)과 2번(추가 예매) 중에 선택하여 주시기 바랍니다.");
    }

    public static void printInvalidPointMessage() {
        System.out.println("포인트는 마이너스일 수 없습니다. 다시 입력해주시기 바랍니다.");
    }

    public static void printInvalidPayType() {
        System.out.println("1번(신용 카드)과 2번(현금) 중에 선택하여 주시기 바랍니다.");
    }

    public static void printResult(int total) {
        System.out.println("최종 결제한 금액은 " + total + "원 입니다.\n예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
