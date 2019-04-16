package error;

import domain.Movie;
import domain.MovieRepository;

public class Validator {

    private static final String WARNING_WHEN_NOT_INTEGER = "정수가 아닙니다";

    // 정수인지
    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            System.out.println(WARNING_WHEN_NOT_INTEGER);
            return false;
        }
    }
}
