package receiver;

import error.Validator;
import error.exceptions.NotIntegerException;
import error.exceptions.NotValidException;

import java.util.Scanner;

public class pointNumberReciever {

    private static final String REQUEST_COMMENT = "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력";
    //재귀 함수를 이용한 구현
    public static int getPointNumFromUser(Scanner sc) {
        System.out.println(REQUEST_COMMENT);
        try {
            String inputFromUser = sc.nextLine();
            checkValid(inputFromUser);
            return Integer.parseInt(inputFromUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPointNumFromUser(sc);
        }
    }

    private static void checkValid(String inputFromUser) throws Exception {
        if (!Validator.isInteger(inputFromUser)) {    // 정수 변환 가능한지
            throw new NotIntegerException();
        }
    }
}
