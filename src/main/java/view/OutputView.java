package view;

import domain.Movie;

import java.util.List;
import java.util.*;
public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    
    public static Movie printSelectMovie(List<Movie> movies, int inputNum) {
    	for (Movie movie: movies) {
    		if (movie.getId() == inputNum) {
    			System.out.println(movie);
    			return movie;
    		}
    	}
    	return null;
    }

    
    public static int printMovieTicket(Movie movie, int inputTime , int inputNum) {
    	System.out.println("예약 내역");
    	System.out.println(movie.getId() + "-" + movie.getName() + "," + movie.getPrice());
    	System.out.print(movie.getPlaySchedule().get(inputTime - 1));
    	System.out.println("예약 인원:" + inputNum);
    	return movie.getPrice() * inputNum;
    }
    
    public static void printResultPay(int payMethod , int MoviePay , int PointPay) {
    	MoviePay = MoviePay - PointPay;
    	if (payMethod == 1) {  // 신용카드 결제 
    		MoviePay = (int) (MoviePay * 0.95);
    	}
    	
    	if (payMethod == 2) { // 현금 결제
    		MoviePay = (int) (MoviePay * 0.98);
    	}
    	
    	System.out.println("최종 결제한 금액은 " + MoviePay + "입니다.");
    	System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
