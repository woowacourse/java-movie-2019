import domain.Movie;
import domain.MovieRepository;
import domain.MyMovie;
import domain.PlaySchedule;
import utils.DateTimeUtils;
import utils.ExceptionCheckedNumber;
import view.InputView;
import view.OutputView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class MovieApplication {
	
	private static final int MORE_BOOK = 2;
	private static final int CREDIT_CARD = 1;
	private static final double CREDIT_CARD_DISCOUNT = 0.95;
	private static final double CASH_DISCOUNT = 0.98;
	private static final String NEW_LINE = "\n";
	
	private Movie selectMovie(List<Movie> movies) {
		ExceptionCheckedNumber movieId;
        try {
        	movieId = new ExceptionCheckedNumber(InputView.inputMovieId());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1 ~ 4 사이의 영화를 선택하세요.");
            movieId = new ExceptionCheckedNumber(InputView.inputMovieId());
        }
    	System.out.println(movies.get(movieId.toArrayIndex()));
    	
        return movies.get(movieId.toArrayIndex());
	}
	
	private PlaySchedule selectMovieTime(Movie movie) {
		ExceptionCheckedNumber movieTime;
        try {
            movieTime = new ExceptionCheckedNumber(InputView.inputMovieTime());  
        } catch (IndexOutOfBoundsException e) {
        	System.out.println("상영시간을 확인 후 다시 선택해주세요");
        	movieTime = new ExceptionCheckedNumber(InputView.inputMovieTime());
        }
        System.out.println(movie.getPlayMovieSchedule(movieTime.toArrayIndex()));
        
        return movie.getPlayMovieSchedule(movieTime.toArrayIndex());
	}
	
	private boolean checkMovieTime(PlaySchedule selectedMovieTime) {
		boolean nowIsBeforeMovie = DateTimeUtils.createNowDateTime().isBefore(selectedMovieTime.getStartDateTime());
		
		if (nowIsBeforeMovie == false) {
			System.out.println("현재 시간 이후에 상영되는 영화를 선택해주세요.");
		}
		
		return nowIsBeforeMovie;
	}
	
	private int inputPeopleNumber() {
		ExceptionCheckedNumber peopleNum;
		try {
			peopleNum = new ExceptionCheckedNumber(InputView.inputPeopleNumber());
		} catch (InputMismatchException e)  {
			System.out.println("1 이상의 숫자를 입력하세요.");
			peopleNum = new ExceptionCheckedNumber(InputView.inputPeopleNumber());
		}
		
		return peopleNum.getNumber();
	}
	
	private boolean checkPeopleNumber(PlaySchedule selectedMovieTime, int peopleNum) {
		boolean isPossible = selectedMovieTime.getCapacity() >= peopleNum ? true : false;
		if (isPossible == false) {
			System.out.println("예약 가능 인원을 초과하였습니다.");
		}
		
		return isPossible;
	}
	
	private List<Movie> getAllMovie() {
		List<Movie> movies = MovieRepository.getMovies();
	    OutputView.printMovies(movies);
	    
	    return movies;
	}
	
	private MyMovie bookMovie(List<Movie> movies, List<MyMovie> myMovies) {
		MyMovie myMovie;
		
		do {
			Movie movie = selectMovie(movies);
	        myMovie = new MyMovie(movie, selectMovieTime(movie), inputPeopleNumber());
		} while(!checkMovieTime(myMovie.getMovieTime()) || !checkTwoMovieTime(myMovie.getMovieTime(), myMovies) 
				|| !checkPeopleNumber(myMovie.getMovieTime(), myMovie.getPeopleNum()));

		return myMovie;
	}
	
	private boolean checkTwoMovieTime(PlaySchedule selectedMovieTime, List<MyMovie> myMovies) {
		boolean isNotOverlaped = true;
		for (int i = 0; i < myMovies.size(); i++) {
			isNotOverlaped = (DateTimeUtils.isOneHourWithinRange(selectedMovieTime.getStartDateTime(), 
					myMovies.get(i).getMovieTime().getStartDateTime()) == true && isNotOverlaped == true) ?  false : true;
		}
		
		isNotOverlaped = myMovies.size() == 0 ? true : false;
		InputView.chooseAnotherTime(isNotOverlaped);
		
		return isNotOverlaped;
	}
	
	private boolean payOrContinue() {
		return (InputView.payOrMoreBook() == MORE_BOOK) ? true : false;
	}
	
	private void printMyMovieInfo(List<MyMovie> myMovies) {
		for (MyMovie myMovie : myMovies) {
			System.out.println(myMovie.toString() + NEW_LINE);
		}
	}
	
	private void payMovie(int point, int payType, List<MyMovie> myMovies) {
		int totalPrice = 0;
		for (MyMovie myMovie : myMovies) {
			totalPrice += (myMovie.getMyMovie().getMoviePrice() * myMovie.getPeopleNum());
		}
		
	    int finalPrice = totalPrice - point;
	    int payPrice = (payType == CREDIT_CARD) ? (int) (finalPrice * CREDIT_CARD_DISCOUNT) : (int) (finalPrice * CASH_DISCOUNT);
	    
	    System.out.println("최종 결제한 금액은 " + payPrice + "원 입니다.");
	    System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
	}


    public static void main(String[] args) {
    	MovieApplication movieApp = new MovieApplication();
    	List<Movie> movies = movieApp.getAllMovie();
    	List<MyMovie> myMovies = new ArrayList<MyMovie>();
    	
    	do {
        	myMovies.add(movieApp.bookMovie(movies, myMovies));
        	System.out.println("영화 예약 완료");
    	} while(movieApp.payOrContinue());
    	
    	movieApp.printMyMovieInfo(myMovies);
    	
    	InputView.continuePayMessage();
    	int point = InputView.inputPoint();
    	int payType = InputView.selectCreditCardOrCash();
    	movieApp.payMovie(point, payType, myMovies);
    	
    }
}
