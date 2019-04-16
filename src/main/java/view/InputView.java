package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String SELECT_MOVIE_TO_RESERVE_MESSAGE = "## 예약할 영화를 선택하세요.";
    private static final String SELECT_MOVIE_PLAY_SCHEDULE_MESSAGE = "## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)";
    private static final String ENTER_PEOPLE_NUMBER_OF_RESERVE_MESSAGE = "## 예약할 인원을 입력하세요.";
    private static final String SELECT_END_OR_ADD_RESERVE_MESSAGE = "## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";


    public static int inputMovieId() {
        System.out.println(SELECT_MOVIE_TO_RESERVE_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputMoviePlaySchedule(){
        System.out.println(SELECT_MOVIE_PLAY_SCHEDULE_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputPeopleNumberOfReservation(){
        System.out.println(ENTER_PEOPLE_NUMBER_OF_RESERVE_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputEndOrAddReservation(){
        System.out.println(SELECT_END_OR_ADD_RESERVE_MESSAGE);
        return scanner.nextInt();
    }
}
