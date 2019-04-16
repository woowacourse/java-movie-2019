import java.util.ArrayList;
import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import domain.SelectedMovie;
import view.InputView;
import view.OutputView;

public class MovieApplication {
	
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<SelectedMovie> selectedMovies = new ArrayList<SelectedMovie>();
        OutputView.printMovies(movies);

        int movieId = recurInputMovieId();
        Movie selectedMovie = MovieRepository.getMovie(movieId);
        System.out.println(selectedMovie);
        
        int selectedSchedule = recurInputSchedule(selectedMovie);
        

        // TODO 구현 진행
        
    }
    
    static int inputMovieIdOnce(){
    	int id = InputView.inputMovieId();
    	MovieRepository.isExist(id);
    	return id;
    }
    
    static int recurInputMovieId() {
    	int id = 0;
    	try {
    		id = inputMovieIdOnce();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			id = recurInputMovieId();
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
}
