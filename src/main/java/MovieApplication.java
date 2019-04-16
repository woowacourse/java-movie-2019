import domain.Movie;
import domain.MovieRepository;
import domain.MyMovie;
import domain.PlaySchedule;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class MovieApplication {
	
	private Movie selectMovie(List<Movie> movies) {
        int movieId = 0;
        try {
        	movieId = InputView.inputMovieId();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1 ~ 4 사이의 영화를 선택하세요.");
            movieId = InputView.inputMovieId();
        }
    	System.out.println(movies.get(movieId - 1));
    	
        return movies.get(movieId - 1);
	}
	
	private PlaySchedule selectMovieTime(Movie movie) {
        int movieTime =0;
        try {
            movieTime = InputView.inputMovieTime();  
        } catch (IndexOutOfBoundsException e) {
        	System.out.println("상영시간을 확인 후 다시 선택해주세요");
            movieTime = InputView.inputMovieTime();
        }
        System.out.println(movie.getPlayMovieSchedule(movieTime - 1));
        
        return movie.getPlayMovieSchedule(movieTime - 1);
	}
	
	private boolean checkMovieTime(PlaySchedule selectedMovieTime) {
		boolean nowIsBeforeMovie = DateTimeUtils.createNowDateTime().isBefore(selectedMovieTime.getStartDateTime());
		
		if (nowIsBeforeMovie == false) {
			System.out.println("현재 시간 이후에 상영되는 영화를 선택해주세요.");
		}
		
		return nowIsBeforeMovie;
	}
	
	private int inputPeopleNumber() {
		int peopleNum = 0;
		try {
			peopleNum = InputView.inputPeopleNumber();
		} catch (InputMismatchException e)  {
			System.out.println("1 이상의 숫자를 입력하세요.");
			peopleNum = InputView.inputPeopleNumber();
		}
		
		return peopleNum;
	}
	
	public boolean checkPeopleNumber(PlaySchedule selectedMovieTime, int peopleNum) {
		boolean isPossible = selectedMovieTime.getCapacity() >= peopleNum ? true : false;
		if (isPossible == false) {
			System.out.println("예약 가능 인원을 초과하였습니다.");
		}
		
		return isPossible;
	}
	
	public List<Movie> getAllMovie() {
		List<Movie> movies = MovieRepository.getMovies();
	    OutputView.printMovies(movies);
	    
	    return movies;
	}
	
	public MyMovie bookMovie(List<Movie> movies) {
		PlaySchedule selectedMovieTime;
		Movie selectedMovie;
		int peopleNum;
		do {
			selectedMovie = selectMovie(movies); // 영화 선택  
	        selectedMovieTime = selectMovieTime(selectedMovie); // 상영시간 선택
	        peopleNum =  inputPeopleNumber();
		} while(!(checkMovieTime(selectedMovieTime) && checkPeopleNumber(selectedMovieTime, peopleNum)));
		MyMovie myMovie = new MyMovie(selectedMovie, peopleNum, selectedMovieTime);
		return myMovie;
	}

    public static void main(String[] args) {
    	MovieApplication movieApp = new MovieApplication();
    	List<Movie> movies = movieApp.getAllMovie();
    	
    	MyMovie movie = movieApp.bookMovie(movies);
    	
        int payOrMoreBook = InputView.payOrMoreBook();
        
        if(payOrMoreBook == 1) {
        	System.out.println(movie.toString());
        	int point = InputView.inputPoint();
        }
 
    }
}
