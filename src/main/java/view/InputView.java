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
    //유효한 아이디면 참 반환
    public static void isValidId(int id, List<Movie> movieList) {
    	boolean result = false;
    	
    	for (Movie movie : movieList) {
			result = result || movie.haveId(id);
		}
    	
    	if (!result) {
    		throw new IllegalArgumentException();
    	}
    }
    
    
    //유효한 아이디에 대해 목록 출력 한다. playsch
    //public static 여기는 시간표 선택 하세요 어떻게 하지 
    // 시간표가 무효하다면 ... 
    public static int inputMovieTimeNumber(Movie movie, MoviePeoples people) {
    	try {
    		System.out.println("## 예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
    		 
    		int result = scanner.nextInt();
    		//유효한 시간표인지, movie 번호 이내인지, 해당 번호자리 충분한지, 기존 시간이랑 한시간 차이 이내인지
    		validTimeTableTest(movie,result);
    		hasAvailbleCapacity(movie,result,people);
    		isVoundedOneHour(movie,result,people);
    		return scanner.nextInt();			
		} catch (Exception e) {
			//예약가능인원이 0인 경우 . 예외처리 
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
