package view;

import domain.Movie;
import utils.InputCheckUtils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
        private static final Scanner scanner = new Scanner(System.in);

        public static int inputMovieId() {
                System.out.println("## 예약할 영화를 선택하세요.");
                try {
                        int input = inputInt();
                        InputCheckUtils.checkInputReservationMoive(input);
                        return input;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputMovieId();
                }
        }

        public static int inputMovieSchedule(int movieId) {
                System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
                try {
                        int selectedSchedule = inputInt();
                        InputCheckUtils.checkInputReservationSchedule(movieId, selectedSchedule);
                        return selectedSchedule;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputMovieSchedule(movieId);
                }
        }


        public static int inputMoviePeople(int movieId, int schedule) {
                System.out.println("## 예약할 인원을 입력하세요.");
                try {
                        int people = inputInt();
                        InputCheckUtils.checkInputMoviePeople(movieId, schedule, people);
                        return people;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputMoviePeople(movieId, schedule);
                }
        }

        public static int inputPayOrAdd() {
                System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
                try {
                        int select = inputInt();
                        InputCheckUtils.checkInputPayOrAdd(select);
                        return select;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputPayOrAdd();
                }
        }

        public static int inputInt() {
                try {
                        return scanner.nextInt();
                } catch (InputMismatchException e) {
                        scanner.nextLine();
                        System.err.println("입력 형식 오류");
                        return inputInt();
                }
        }
}
