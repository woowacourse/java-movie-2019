package view;

import java.util.Scanner;

import domain.ErrorCheck;
import domain.Movie;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId () {
        System.out.println("## 예약할 영화를 선택하세요.");
        int movieId = scanner.nextInt();
        if(!ErrorCheck.isValidMovie(movieId)) {
        	return inputMovieId();
        }
        return movieId;
       
    }
    
    public static int inputMovieTime(Movie movie) {
    	System.out.println("##예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번");
    	int movieTime = scanner.nextInt();
    	if(!ErrorCheck.isValidTime(movie, movieTime)) {
    		return inputMovieTime(movie);
    	}
    	/*if(!ErrorCheck.isWithinOneHour(movie, movieTime)) {
    		return inputMovieTime(movie);
    	}*/
    	
    	return movieTime;
    }
    
    public static int inputMoviePeople() {
    	System.out.println("##예약할 인원을 입력하세요.");
    	return scanner.nextInt();
    }
    
    public static int inputCalculateOrAddMovie() {
    	System.out.println("##예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
    	return scanner.nextInt();
    	
    }
    
    public static int inputPoint() {
    	System.out.println("##결제를 진행합니다.");
    	System.out.println("포인트 사용 금액을 입력하세요. 포인트가 없으면 0입력");
    	return scanner.nextInt();
    }
    
    public static int inputCashOrCard() {
    	System.out.println("신용카드는 1번, 현금은 2번");
    	return scanner.nextInt();
    }
}
