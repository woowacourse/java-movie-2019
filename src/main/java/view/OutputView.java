package view;

import domain.Movie;
import utils.DateTimeUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static utils.DateTimeUtils.format;
import static utils.DateTimeUtils.isOneHourWithinRange;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    /*
     * 예약할 영화를 출력하고 담음
     */
    public static Movie getAndprintChosenMovie(List<Movie> movies, int movieId) {
        boolean answer = false;
        Movie movie = null;
        for (int i = 0; i < movies.size() && answer == false; i++) {
            movie = movies.get(i);
            boolean recognize = false;
            recognize = (movie.getId() == movieId) ? true : false;
            answer = answer || recognize;
        }
        System.out.println(movie);
        return movie;
    }

    /*
     * 실패 조건에 부합하면 오류를 발생
     */
    public static void makeFail(Movie movie, List<LocalDateTime> times, LocalDateTime localDateTime) {
        if (judgeOneHour(times, localDateTime) && judgeStartTime(movie, times.get(times.size() - 1)) == false) {
            throw new IllegalArgumentException();
        }

    }

    /*
     * 상영 시작 시간이 현재 시각보다 나중인지 여부 판단
     */
    public static boolean judgeStartTime(Movie movie, LocalDateTime localDateTime) {
        if (localDateTime.isBefore(LocalDateTime.now())) {
            System.out.println("상영 시작 시간이 이미 지난 영화입니다.");
            return false;
        }
        return true;
    }

    /*
     * 두 영화의 시간 차이가 1시간 이내인지 여부
     */
    public static boolean judgeOneHour(List<LocalDateTime> times, LocalDateTime localDateTime) {
        boolean answer = true;
        for (int i = 0; i < times.size() - 2; i++) {
            answer = answer && isOneHourWithinRange(times.get(i), localDateTime);
        }

        return answer;
    }

    /*
     * 예매 내역 출력
     */
    public static void printReservation(List<Movie> movies, List<LocalDateTime> localDateTimes, List<Integer> list) {
        System.out.println("예매 내역");
        for (int i = 0; i < movies.size()
                && i < localDateTimes.size()
                && i < list.size(); i++) {
            System.out.println(movies.get(i).toStringTitile());
            System.out.println(format(localDateTimes.get(i)));
            System.out.println("예약 인원: " + list.get(i) + "명");
            System.out.println();
        }
    }

    /*
     * 결제 진행
     */
    public static void printPurchase() {
        System.out.println("## 결제를 진행합니다.");
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
    }
}
