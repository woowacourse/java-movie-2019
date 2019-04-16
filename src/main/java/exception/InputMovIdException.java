package exception;

public class InputMovIdException extends RuntimeException {
    public String EXCEPTION_STR;

    public InputMovIdException(){}

    public InputMovIdException(String str){
        this.EXCEPTION_STR = str;
    }
}
