package utils;


public class ExceptionCheckedNumber {

	  private static final int INTERVAL = 1;

	  private int number;

	  public ExceptionCheckedNumber(int number) {
	    if ((int)number < 1) {
	      throw new IllegalArgumentException(String.format("1 이상의 자연수를 입력하세요. 현재 값은 : %d", number));
	    }
	    
	    this.number = (int)number;
	    
	  }

	  public int getNumber() {
	    return this.number;
	  }

	  public int toArrayIndex() {
	    return this.number - INTERVAL;
	  }
	
}
