package error.exceptions;

public class NotValidException  extends Exception {
    static final String WARNING_COMMENT = "유효한 수가 아닙니다..";

    public NotValidException() {
        super(WARNING_COMMENT);
    }
}
