package view;

import java.util.List;
import java.util.Scanner;

import domain.Movie;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
    	try {
    		System.out.println("## 예약할 영화를 선택하세요.");
    		return scanner.nextInt();			
		} catch (Exception e) {
			System.out.println("유효한 값을 입력해주세요.");
			return inputMovieId();
		} 
    }
    //유효한 아이디면 참 반환
    public static boolean isValidId(int id, List<Movie> movieList) {
    	boolean result = false;
    	
    	for (Movie movie : movieList) {
			result = result || movie.haveId(id);
		}
    	
    	return result;
    }
    
    //유효한 아이디에 대해 목록 출력 한다. playsch
    //public static
    
}
