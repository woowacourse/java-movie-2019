package view;

import domain.Movie;
import domain.MovieRepository;
import domain.OneOrTwoToken;
import utils.InputUtil;

public class InputView {

    public static Movie inputMovie() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            OutputView.printMovies(MovieRepository.getMovies());
            Movie movie = MovieRepository.getWantMovie(InputUtil.getInt());
            movie.checkMovieValid();
            return movie;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMovie();
        }
    }

    public static int InputTimeScheduleIndex(Movie movie) {
        System.out.println("# 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
        try {
            int timeScheduleIndex = InputUtil.getInt();
            movie.checkTimeScheduleValid(timeScheduleIndex);
            return timeScheduleIndex;
        } catch (Exception e) {
            System.out.println("제대로된 스케쥴 일정을 입력해주세요");
            return InputTimeScheduleIndex(movie);
        }
    }

    public static int inputCustomerBuyCount() {
        System.out.println("# 예약할 인원을 입력");
        return InputUtil.getInt();
    }

    public static OneOrTwoToken inputContinue() {
        System.out.println("# 예약을 종료하고 결제를 완료하려면 1번, 추가 예약하실려면 2번을 눌러주세요");
        try {
            return new OneOrTwoToken(InputUtil.getInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputContinue();
        }
    }

    public static int inputPoint() {
        System.out.println("## 결제 진행합니다");
        System.out.println("포인트 사용금액을 입력하세요");
        return InputUtil.getInt();
    }

    public static OneOrTwoToken getCreditOrCash() {
        try {
            System.out.println("신용카드는 1번 현금은 2번");
            return new OneOrTwoToken(InputUtil.getInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCreditOrCash();
        }
    }
}
