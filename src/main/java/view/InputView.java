package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MOVIE_NUMBER_ERROR = "영화 목록에 해당되는 숫자를 입력해주세요";
    public static final int BIRTHDAY = 1;
    public static final int MONEY = 5;
    public static final int FIVE_FEET = 7;
    public static final int DUMBO = 8;
    
    public static int movieNumber;

    public static int inputMovieId() {
    	System.out.println("## 예약할 영화를 선택하세요.");
    	do {
    		System.out.println(INPUT_MOVIE_NUMBER_ERROR);
    	} while(!isValidMovieNumberCondition());
    	return movieNumber;
    }
    
    private static boolean isValidMovieNumberCondition() {
    	try {
    		String tempNumber = scanner.nextLine();
    		movieNumber = Integer.parseInt(tempNumber);
    		return isValidMovieNumberRange(movieNumber);
    	} catch(NumberFormatException e) {
    		return false;
    	}
    }
    
    private static boolean isValidMovieNumberRange(int movieNumber) {
    	return (movieNumber == BIRTHDAY || movieNumber == MONEY
    			|| movieNumber == FIVE_FEET || movieNumber == DUMBO ? true : false);
    }			
}
