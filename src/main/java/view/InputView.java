package view;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import domain.Movie;
import domain.MoviePeoples;
import domain.PlaySchedule;
import utils.DateTimeUtils;

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

    public static void isValidId(int id, List<Movie> movieList) {
    	boolean result = false;
    	
    	for (Movie movie : movieList) {
			result = result || movie.haveId(id);
		}
    	
    	if (!result) {
    		throw new IllegalArgumentException();
    	}
    }
    
    public static int inputMovieTimeNumber(Movie movie, MoviePeoples people) {
    	try {
    		System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
    		 
    		int result = scanner.nextInt();
    		
    		validTimeTableTest(movie,result);
    		hasAvailbleCapacity(movie,result,people);
    		isVoundedOneHour(movie,result,people);
    		return scanner.nextInt();			
		} catch (Exception e) {

			return inputMovieTimeNumber(movie,people);
		} 
    }
	private static void isVoundedOneHour(Movie movie, int result, MoviePeoples people) {
		PlaySchedule ps = movie.getPlaySchedule().get(result-1);		//i번을 입력했을때 값
		boolean res = true;
		
		for (LocalDateTime time : people.getTimeList()) {
			res = res && 
					DateTimeUtils
					.isOneHourWithinRange(ps.getStartTime(), time);
		}
		if (!res) {
			System.out.println("시간간격이 한시간이 넘어갑니다.");
			throw new IllegalArgumentException();
		}
	}
	private static void hasAvailbleCapacity(Movie movie, int result, MoviePeoples people) {
		if(people.isAvailable(movie, result, 0)) {
			System.out.println("좌석이 부족합니다.");
			throw new IllegalArgumentException();
		}
		
		
	}
	private static void validTimeTableTest(Movie movie, int result) {
		if (result >movie.getPlaySchedule().size() ||
				result < 0) {
			System.out.println("존재하지 않는 상영시간표입니다.");
			throw new IllegalArgumentException();
		}
	}
	public static Movie getMovieById(List<Movie> movies, int movieId) {
		Movie result = null;
		
		for (Movie movie : movies) {
			if (movie.haveId(movieId)) {
				result = movie;
			}
		}
		return result;
	}
	
}
