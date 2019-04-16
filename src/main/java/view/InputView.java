package view;

import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservationMachine;
import domain.PlaySchedule;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NOT_INTEGER_ERROR_MESSAGE = "정수를 입력해 주세요.";


    /**
     * 현재 상영중인 영화의 번호들 중 하나를 입력받는 메소드. 성공할 때까지 반복함.
     */
    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        int movieId;
        try {
            return getValidMovieId();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }

    /**
     * 영화 번호를 입력받는 메소드. 실패할 경우 예외를 던짐.
     */
    private static int getValidMovieId() {
        int userMovieId = getInteger();
        if (MovieRepository.isValidMovieId(userMovieId)) {
            return userMovieId;
        }
        throw new InputMismatchException("해당 번호에 해당하는 영화가 존재하지 않습니다.");
    }

    /**
     * 예매할 시간대 번호를 입력받는 메소드. 성공할 때까지 반복함.
     */
    public static int inputScheduleId(int movieId) {
        System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
        try {
            return getValidScheduleId(movieId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputScheduleId(movieId);
        }
    }

    /**
     * 예매할 시간대 번호를 입력받는 메소드. 실패할 경우 예외를 던짐.
     */
    private static int getValidScheduleId(int movieId) {
        int userScheduleId = getInteger();
        Movie movie = MovieRepository.getMovieWithId(movieId);
        if (movie.isValidScheduleId(userScheduleId)) {
            return userScheduleId;
        }
        throw new InputMismatchException("해당 번호에 해당하는 시간대가 존재하지 않습니다.");
    }

    /**
     * 인원을 입력받는 메소드. 성공할 때까지 반복함.
     */
    public static int inputPersonnels(int movieId, int scheduleId) {
        System.out.println("## 예약할 인원을 입력하세요.");
        try {
            return getValidPersonnels(movieId, scheduleId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPersonnels(movieId, scheduleId);
        }
    }

    /**
     * 인원을 입력받는 메소드. 실패할 경우 예외를 던짐.
     */
    private static int getValidPersonnels(int movieId, int scheduleId) {
        int personnels = getInteger();
        Movie movie = MovieRepository.getMovieWithId(movieId);
        PlaySchedule schedule = movie.getSchedule(scheduleId);
        if (schedule.isCapable(personnels) && personnels >= 1) {
            return personnels;
        }
        throw new InputMismatchException("입력하신 인원은 수용할 수 없습니다.");
    }


    /**
     * 예매 지속 여부를 입력받는 메소드. 1이면 종료, 2이면 지속
     */
    public static int inputContinue() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        try {
            return getValidContinueInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputContinue();
        }
    }

    private static int getValidContinueInput() {
        int userInput = getInteger();
        if (userInput == 1 || userInput == 2) {
            return userInput;
        }
        throw new InputMismatchException("1 혹은 2의 숫자만 입력해 주세요.");
    }

    /**
     * 사용자가 사용할 포인트를 입력받는다.
     */
    public static int inputPoint() {
        System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
        try {
            return getValidPointInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputContinue();
        }
    }

    private static int getValidPointInput() {
        int userInput = getInteger();
        if (userInput >= 0) {
            return userInput;
        }
        throw new InputMismatchException("0 이상의 정수만 입력해 주세요.");
    }


    /**
     * 정수 하나를 입력받는 메소드. 실패할 경우 예외를 던짐.
     */
    private static int getInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new InputMismatchException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

}
