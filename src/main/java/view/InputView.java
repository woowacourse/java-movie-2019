package view;

import domain.MovieRepository;
import domain.Movie;
import domain.MovieReservation;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        int movieId = scanner.nextInt();

        if (MovieRepository.isValidId(movieId)) {
            return movieId;
        }

        return inputMovieId();
    }

    public static int inputScheduleId(List<MovieReservation> reservations, Movie movie) {
        System.out.println("\n## 예약할 시간표를 선택하세요. (첫번째 상영시간이 1번)");
        int scheduleId = scanner.nextInt() - 1;

        if (movie.isValidScheduleId(reservations, scheduleId)) {
            return scheduleId;
        }

        return inputScheduleId(reservations, movie);
    }

    public static int inputReservationNumber(Movie movie, int scheduleId) {
        System.out.println("\n## 예약할 인원을 입력하세요.");
        int reservationNumber = scanner.nextInt();

        if (movie.isValidReservationNumber(scheduleId, reservationNumber)) {
            return reservationNumber;
        }

        return inputReservationNumber(movie, scheduleId);
    }

    public static int inputIsContinue() {
        System.out.println("\n## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        int inputNumber = scanner.nextInt();

        if ((inputNumber == 1) || (inputNumber == 2)) {
            return inputNumber;
        }

        return inputIsContinue();
    }

    public static int inputPoint(int totalPrice) {
        System.out.println("\n## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
        int point = scanner.nextInt();

        if (point <= totalPrice) {
            return point;
        }

        System.out.println(String.format(
                "## 총 금액보다 포인트 사용 금액이 큽니다. 총 금액은 %d 입니다.", totalPrice));
        return inputPoint(totalPrice);
    }
}
