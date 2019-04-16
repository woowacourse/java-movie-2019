import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.SelectedMovie;
import view.InputView;
import view.OutputView;

public class MovieApplication {
	
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<SelectedMovie> selectedMovies = new ArrayList<SelectedMovie>();
        OutputView.printMovies(movies);

        recurSelectMovieOrNot(movies);
    }
    
	static void isExist(List<Movie> movies, int id) {
		int isNot = 1;
		for (Movie movie : movies) {
			isNot *= (movie.isTheMovie(id)) ? 0 : 1;
		}
		if (isNot == 1) {
			throw new IllegalArgumentException("해당 아이디의 영화가 없습니다. \n다시 입력해주세요.");
		}
	}
	
	static Movie getMovie(List<Movie> movies, int id) {
		Movie ret = null;
		Iterator<Movie> it = movies.iterator();
		while (it.hasNext() && ret == null) {
			Movie tmp = it.next();
			ret = (tmp.isTheMovie(id)) ? tmp : null;
		}
		return ret;
	}
    
    static int inputMovieIdOnce(List<Movie> movies){
    	int id = InputView.inputMovieId();
    	isExist(movies, id);
    	return id;
    }
    
    static int recurInputMovieId(List<Movie> movies) {
    	int id = 0;
    	try {
    		id = inputMovieIdOnce(movies);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			id = recurInputMovieId(movies);
		}
    	return id;
    }
    
    static int inputScheduleOnce(Movie movie){
    	int input = InputView.inputSchedule();
    	if(!movie.isValidSchedule(input))
    		throw new IllegalArgumentException("선택한 영화 상영 스케쥴이 없습니다. \n다시 입력해주세요.");
    	return input;
    }
    
    static int recurInputSchedule(Movie movie) {
    	int input = 0;
    	try {
    		input = inputScheduleOnce(movie);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			input = recurInputSchedule(movie);
		}
    	return input;
    }
    
    static int inputPeopleOnce(PlaySchedule schedule){
    	int input = InputView.inputNumOfPeople();
    	if(input <= 0)
    		throw new IllegalArgumentException("인원 수는 0보다 커야 합니다. \n다시 입력해 주세요.");
    	if(!schedule.isValidPeople(input))
    		throw new IllegalArgumentException("예약 가능 인원을 초과합니다. \n다시 입력해 주세요.");
    	return input;
    }
    
    static int recurInputPeople(PlaySchedule schedule) {
    	int input = 0;
    	try {
    		input = inputPeopleOnce(schedule);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			input = recurInputPeople(schedule);
		}
    	return input;
    }
    
    static SelectedMovie inputSelectedMovieOnce(List<Movie> movies) {
    	int movieId = recurInputMovieId(movies);
        Movie selectedMovie = getMovie(movies, movieId);
        System.out.println(selectedMovie);
        int indexOfSelectedSchedule = recurInputSchedule(selectedMovie);
        PlaySchedule selectedSchedule = selectedMovie.getSchedule(indexOfSelectedSchedule);
        int numOfPeople = recurInputPeople(selectedSchedule);
        return new SelectedMovie(selectedMovie, indexOfSelectedSchedule, numOfPeople);
    }
	
	static void subtractCapacity(List<Movie> movies, SelectedMovie selectedMovie) {
		int movieId = selectedMovie.getMovie().getId();
		int indexOfSchedule = selectedMovie.getIndexOfSelectedSchedule();
		int numOfPeople = selectedMovie.getNumOfPeople();
		Movie movie = getMovie(movies, movieId);
    	movie.getSchedule(indexOfSchedule).subtractCapacity(numOfPeople);
	}
    
    static int recurInputRechoiceOrNot() {
    	int input = 0;
    	try {
    		input = InputView.inputRechoiceOrNot();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			input = InputView.inputRechoiceOrNot();
		}
    	return input;
    }
    
    static void recurSelectMovieOrNot(List<Movie> movies) {
    	List<SelectedMovie> selectedMovies = new ArrayList<SelectedMovie>();
    	int swc = 2;
    	do {
    		SelectedMovie selectedMovie = inputSelectedMovieOnce(movies);
    		selectedMovies.add(selectedMovie);
    		subtractCapacity(movies, selectedMovie);
    		swc = recurInputRechoiceOrNot();
    	} while(swc == 2);
    }
}
