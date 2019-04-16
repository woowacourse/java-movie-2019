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
            int reserveMovie = scanner.nextInt();
            ReservedMovie reservedMovie = new ReservedMovie(reserveMovie);
            return reservedMovie.getReservedMovie();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputMovieId();
        }
    }

    public static PlaySchedule inputReserveTime(Movie movie) {
        try {
            System.out.println("##예약할시간표를선택하세요.(첫번째상영시간이1번)");
            int reserveTime = scanner.nextInt();
            ReserveTime reserveTime1 = new ReserveTime(movie, reserveTime);
            return reserveTime1.getReserveSchedule();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputReserveTime(movie);
        }
    }

    public static ReservePeople inputReservePeople(PlaySchedule reserveSchedule) {
        try {
            System.out.println("##예약할인원을입력하세요. ");
            int reservePeople = scanner.nextInt();
            ReservePeople reservePeople1 = new ReservePeople(reserveSchedule, reservePeople);
            return reservePeople1;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputReservePeople(reserveSchedule);
        }
    }

    public static PaymentOrReservation inputPaymentOrReservation() {
        try {
            System.out.println("##예약을종료하고결제를진행하려면1번, 추가예약을진행하려면2번 ");
            int paymentOrReservation = scanner.nextInt();
            PaymentOrReservation paymentOrReservation1 = new PaymentOrReservation(paymentOrReservation);
            return paymentOrReservation1;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputPaymentOrReservation();
        }
    }

    public static List<Integer> ConvertStringToInt(List<String> movies) {
        List<Integer> reservateMovies = movies.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return reservateMovies;
    }
}
