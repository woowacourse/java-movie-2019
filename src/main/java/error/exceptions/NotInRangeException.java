package error.exceptions;

public class NotInRangeException extends Exception {
    static final String WARNING_COMMENT = "존재하는 영화 번호가 아닙니다.";
    public NotInRangeException() {
        super(WARNING_COMMENT);
    }
}
