package receiver;

import error.Validator;
import error.exceptions.NotIntegerException;
import error.exceptions.NotValidException;

import java.util.Scanner;

public class scheduleNumReceiver {
    private static final String REQUEST_COMMENT = "##예약할 시간표를 선택하세요(첫번째 상영 시간이 1번)";
    //재귀 함수를 이용한 구현
    public static int getScheduleNumFromUser(Scanner sc) {
        System.out.println(REQUEST_COMMENT);
        try {
            String inputFromUser = sc.nextLine();
            checkValid(inputFromUser);
            return Integer.parseInt(inputFromUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getScheduleNumFromUser(sc);
        }
    }

    private static void checkValid(String inputFromUser) throws Exception {
        if (!Validator.isInteger(inputFromUser)) {    // 정수 변환 가능한지
            throw new NotIntegerException();
        }
        int movieNum = Integer.parseInt(inputFromUser);
        if (1 > movieNum || movieNum > 9) {    // 적은 금액인지
            throw new NotValidException();
        }
    }
}
