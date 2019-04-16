import java.util.List;

import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

public class MovieApplication {
	
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = recurInputMovieId();
        

        // TODO 구현 진행
        
    }
    static int inputMovieIdOnce(){
    	int ret = InputView.inputMovieId();
    	MovieRepository.isExist(ret);
    	return ret;
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
}
