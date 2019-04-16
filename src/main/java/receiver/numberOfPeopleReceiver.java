package receiver;

import error.Validator;
import error.exceptions.NotIntegerException;
import error.exceptions.NotValidException;

import java.util.Scanner;

public class numberOfPeopleReceiver {
    private static final String REQUEST_COMMENT = "##예약할 인원을 입력하세요";
    //재귀 함수를 이용한 구현
    public static int getPeopleNumFromUser(Scanner sc) {
        System.out.println(REQUEST_COMMENT);
        try {
            String inputFromUser = sc.nextLine();
            checkValid(inputFromUser);
            return Integer.parseInt(inputFromUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPeopleNumFromUser(sc);
        }
    }

    private static void checkValid(String inputFromUser) throws Exception {
        if (!Validator.isInteger(inputFromUser)) {    // 정수 변환 가능한지
            throw new NotIntegerException();
        }
    }
}
