package view;


import domain.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Movie inputMovieId() {
        try {
            System.out.println("## 예약할 영화를 선택하세요.");
            ReservedMovie reservedMovie = new ReservedMovie(scanner.nextInt());
            return reservedMovie.getReservedMovie();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputMovieId();
        }
    }

    public static PlaySchedule inputReserveTime(Movie movie) {
        try {
            System.out.println("##예약할시간표를선택하세요.(첫번째상영시간이1번)");
            ReserveTime reserveTime = new ReserveTime(movie,scanner.nextInt());
            return reserveTime.getReserveSchedule();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputReserveTime(movie);
        }
    }

    public static ReservePeople inputReservePeople(PlaySchedule reserveSchedule) {
        try {
            System.out.println("##예약할인원을입력하세요. ");
            ReservePeople reservePeople = new ReservePeople(reserveSchedule,  scanner.nextInt());
            return reservePeople;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputReservePeople(reserveSchedule);
        }
    }

    public static PaymentOrReservation inputPaymentOrReservation() {
        try {
            System.out.println("##예약을종료하고결제를진행하려면1번, 추가예약을진행하려면2번 ");
            PaymentOrReservation paymentOrReservation = new PaymentOrReservation(scanner.nextInt());
            return paymentOrReservation;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputPaymentOrReservation();
        }
    }

    public static Point inputPoint(ReservateInformation reservateInformation) {
        try {
            System.out.println("##결제를진행합니다.");
            System.out.println("##포인트사용금액을입력하세요.포인트가없으면0입력");
            Point point = new Point(reservateInformation, scanner.nextInt());
            return point;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputPoint(reservateInformation);
        }
    }

    public static CardOrCash inputCardOrCash(){
        try {
            System.out.println("신용카드는 1번, 카드는 2번입니다.");
            CardOrCash cardOrCash = new CardOrCash(scanner.nextInt());
            return cardOrCash;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return inputCardOrCash();
        }

    }

    public static List<Integer> ConvertStringToInt(List<String> movies) {
        List<Integer> reservateMovies = movies.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return reservateMovies;
    }
}
