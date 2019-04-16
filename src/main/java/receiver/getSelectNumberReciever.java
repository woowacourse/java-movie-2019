package receiver;

import error.Validator;
import error.exceptions.NotIntegerException;
import error.exceptions.NotValidException;

import java.util.Scanner;

public class getSelectNumberReciever {
    private static final String REQUEST_COMMENT = "##예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";
    //재귀 함수를 이용한 구현
    public static int getSelectNumberReciever(Scanner sc) {
        System.out.println(REQUEST_COMMENT);
        try {
            String inputFromUser = sc.nextLine();
            checkValid(inputFromUser);
            return Integer.parseInt(inputFromUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getSelectNumberReciever(sc);
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
