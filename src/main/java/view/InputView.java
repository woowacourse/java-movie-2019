package view;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.InputNumber;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String SELECT_MOVIE_TO_RESERVE_MESSAGE = "## 예약할 영화를 선택하세요.";
    private static final String SELECT_MOVIE_PLAY_SCHEDULE_MESSAGE = "## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)";
    private static final String ENTER_PEOPLE_NUMBER_OF_RESERVE_MESSAGE = "## 예약할 인원을 입력하세요.";
    private static final String SELECT_END_OR_ADD_RESERVE_MESSAGE = "## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";
    private static final String ENTER_AMOUNT_OF_POINT_TO_USE_MESSAGE = "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력";
    private static final String SELECT_PAYMENT_METHOD_MESSAGE = "## 신용카드는 1번, 현금은 2번";

    private static final String STARTED_MOVIE_MESSAGE = "이미 상영이 시작된 영화 입니다.";
    private static final String NOT_EXIST_MOVIE_ID_ERROR_MESSAGE = "존재하지 않는 영화 입니다.";
    private static final String NOT_ABLE_CAPACITY_MESSAGE = "예매 가능 인원을 초과 했습니다.";

    private static final int END_RESERVATION = 1;
    private static final int ADD_RESERVATION = 2;
    private static final String END_OR_ADD_RESERVE_ERROR_MESSAGE = "예약을 종료하고 결제려면 1, 추가 예약을 진행하려면 2를 선택하셔야 합니다.";

    private static final int MIN_POINT = 0;
    private static final String POINT_INPUT_ERROR_MESSAGE = "포인트는 0보다 작을 수 없습니다.";

    private static final int CREDIT_CARD_PAYMENT_METHOD = 1;
    private static final int CASH_PAYMENT_METHOD = 2;
    private static final String PAYMENT_METHOD_ERROR_MESSAGE = "유요한 결제 방식(1 또는 2)을 선택하셔야 합니다.";


    public static int inputMovieId() {
        System.out.println(SELECT_MOVIE_TO_RESERVE_MESSAGE);
        int movieId = InputNumber.getNaturalNumber();
        if(!MovieRepository.isExistMovie(movieId)){
            System.out.println(NOT_EXIST_MOVIE_ID_ERROR_MESSAGE);
            return inputMovieId();
        }
        return movieId;
    }

    public static int inputMoviePlaySchedule(Movie movie) {
        System.out.println(SELECT_MOVIE_PLAY_SCHEDULE_MESSAGE);
        int playScheduleId = InputNumber.getNaturalNumber();
        if(!movie.isNotStartedMovie(playScheduleId)){
            System.out.println(STARTED_MOVIE_MESSAGE);
            return inputMoviePlaySchedule(movie);
        };

        return playScheduleId;
    }

    public static int inputPeopleNumberOfReservation(PlaySchedule playSchedule) {
        System.out.println(ENTER_PEOPLE_NUMBER_OF_RESERVE_MESSAGE);
        int peopleNumber = InputNumber.getNaturalNumber();
        if(peopleNumber > playSchedule.getCapacity()){
            System.out.println(NOT_ABLE_CAPACITY_MESSAGE);
            return inputPeopleNumberOfReservation(playSchedule);
        }
        return peopleNumber;
    }

    public static int inputEndOrAddReservation() {
        System.out.println(SELECT_END_OR_ADD_RESERVE_MESSAGE);
        try{
            int endOrAdd = InputNumber.getNaturalNumber();
            if (endOrAdd != END_RESERVATION && endOrAdd != ADD_RESERVATION) {
                System.out.println(END_OR_ADD_RESERVE_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
            return endOrAdd;
        }catch (Exception e){
            return inputEndOrAddReservation();
        }

    }

    public static int inputAmountOfPointToUse() {
        System.out.println(ENTER_AMOUNT_OF_POINT_TO_USE_MESSAGE);
        try {
            int point = InputNumber.getNaturalNumber();
            if (point < MIN_POINT) {
                System.out.println(POINT_INPUT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
            return point;
        } catch (Exception e) {
            return inputAmountOfPointToUse();
        }
    }

    public static int inputPaymentMethod() {
        System.out.println(SELECT_PAYMENT_METHOD_MESSAGE);
        try {
            int paymentMethod = InputNumber.getNaturalNumber();
            if (paymentMethod != CREDIT_CARD_PAYMENT_METHOD && paymentMethod != CASH_PAYMENT_METHOD) {
                System.out.println(PAYMENT_METHOD_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
            return paymentMethod;
        } catch (Exception e) {
            return inputPaymentMethod();
        }
    }
}
