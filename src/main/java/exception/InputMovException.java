package exception;

public class InputMovException extends RuntimeException {
    public String EXCEPTION_STR;

    public InputMovException(){}

    public InputMovException(String str){
        this.EXCEPTION_STR = str;
    }
}
