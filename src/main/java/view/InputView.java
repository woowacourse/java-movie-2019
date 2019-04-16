/*
 * @(#)InputView.java
 *
 * v 0.0.0
 *
 * 2019.04.16
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package view;

import java.util.Scanner;

import domain.Movie;
import domain.MovieRepository;

/**
 * 사용자 입력을 받는 클래스가 모여있는 클래스
 *
 * @version 0.0.0
 * @author kwonmc
 * @author WoowahanTechCamp
 */
public class InputView {
    private static final String MOVIE_ID = "## 예약할 영화를 선택하세요.";
    private static final String MOVIE_TIME = "## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)";
    private static final String RESERVE_COUNT = "## 예약할 인원을 입력하세요.";
    private static final String CHOOSE_PROCESS = "## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";
    private static final String POINT_AMOUNT = "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력";
    private static final String PAY_TYPE = "## 신용카드는 1번, 현금은 2번";

    private static final String ONE_OR_TWO_EXCEPTION = "유효한 입력이 아닙니다.";

    private static final Scanner scanner = new Scanner(System.in);

    public static Movie inputMovieId() {
        System.out.println(MOVIE_ID);
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return MovieRepository.getMovieById(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMovieId();
        }
    }

    public static int inputMovieTime(Movie movie) {
        System.out.println(MOVIE_TIME);
        try {
            int input = Integer.parseInt(scanner.nextLine());
            movie.isValidCapacity(input, 1);

            return movie.isValidTime(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMovieTime(movie);
        }
    }

    public static int inputReserveCount(int id, Movie movie) {
        System.out.println(RESERVE_COUNT);
        try {
            int input = Integer.parseInt(scanner.nextLine());
            return movie.isValidCapacity(id, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputReserveCount(id, movie);
        }
    }

    public static int inputChooseProcess() {
        System.out.println(CHOOSE_PROCESS);
        try {
            int input = Integer.parseInt(scanner.nextLine());
            isInputOneOrTwoValid(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputChooseProcess();
        }
    }

    private static void isInputOneOrTwoValid(int input) {
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException(ONE_OR_TWO_EXCEPTION);
        }
    }

    public static int inputPointAmount() {
        try {
            System.out.println(POINT_AMOUNT);
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            return inputPointAmount();
        }
    }

    public static int inputPayType() {
        System.out.println(PAY_TYPE);
        try {
            int input = Integer.parseInt(scanner.nextLine());
            isInputOneOrTwoValid(input);
            return input;
        } catch (IllegalArgumentException e) {
            return inputPayType();
        }
    }
}
