package error.exceptions;

public class NotIntegerException extends Exception {
    static final String WARNING_COMMENT = "정수가 아닙니다.";

    public NotIntegerException() {
        super(WARNING_COMMENT);
    }
}