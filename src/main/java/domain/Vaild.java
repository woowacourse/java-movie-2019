package domain;

import java.util.List;

public class Vaild {
	List<Movie> movies = MovieRepository.getMovies();
	
	public boolean PaymentVaild(int MoviePay,int PointPay) {
		boolean result = false;
		if (PointPay < 0) {
			System.out.println("포인트는 0보다 큰 수만 입력가능합니다. 포인트가 없으시면 0을 입력해주세요.");
			result = true;
		}
		
		if (PointPay > MoviePay) {
			System.out.println("입력하신 포인트가 영화 가격보다 높습니다. 사용할 포인트를 다시 입력해주세요.");
			result = true;
		}
		return result;
	}
	
	public boolean movieNumVaild(int movieNum) {
		
		boolean result = false;
		int count = 0;
    	for (Movie movie: movies) {
    		if (movie.getId() == movieNum) {
    			count++;
    		}
    	}
		if (count == 0) {
			System.out.println("해당 번호의 영화는 현재 상영 중이아닙니다.");
			result = true;
		}
		return result;
	}
}
