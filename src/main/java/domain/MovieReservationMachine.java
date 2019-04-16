package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 영화 예매기 역할을 하는 클래스
 */
public class MovieReservationMachine {
    private static List<Reservation> reservationHistory = new ArrayList();

    /**
     * 현재 상영중인 영화들의 목록을 출력하는 메소드
     */
    public static void showAvailableMovies() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    /**
     * 특정 영화의 스케쥴을 출력하는 메소드
     */
    public static void showSchedulesOfMovieWithId(int id) {
        OutputView.printMovie(MovieRepository.getMovieWithId(id));
    }

    /**
     * 사용자의 예매 건을 예매 내역에 추가한다.
     */
    public static void addReservation(int movieId, int scheduleId, int personnels) {
        Movie thisMovie = MovieRepository.getMovieWithId(movieId);
        thisMovie.getSchedule(scheduleId).reduceCapacity(personnels);
        reservationHistory.add(new Reservation(thisMovie, scheduleId, personnels));
    }

    /**
     * 예매 내역을 보여준다.
     */
    public static void showReservatoinHistory() {
        Iterator<Reservation> it = reservationHistory.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println();
        }
    }

    /**
     * 결제가 시작한다는 메시지를 출력한다.
     */
    public static void printPaymentStartMessage() {
        System.out.println("## 결제를 진행합니다.");
    }

    /**
     * 결제 금액을 계산하고 출력한다.
     */
    public static void processPayment(int point, int howToPay) {
        double reduceRate = (howToPay == 1) ? 0.05 : 0.02;

        int totalPay = 0;
        Iterator<Reservation> it = reservationHistory.iterator();
        while (it.hasNext()) {
            totalPay += it.next().howMuch();
        }
        System.out.println("최종 결제한 금액은 " + (int)((totalPay - point) * (1-reduceRate)) + "원 입니다.");
    }

    /**
     * Good-Bye 메시지를 출력한다.
     */
    public static void printGoodBye() {
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
