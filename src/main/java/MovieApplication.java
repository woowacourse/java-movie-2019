import java.util.List;

import domain.Movie;
import domain.MoviePeoples;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

public class MovieApplication {
    public static void main(String[] args) {
    	MovieApplication movieApp = new MovieApplication();
    	MoviePeoples poeple= new MoviePeoples(); 
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        
        
        int movieId = InputView.inputMovieId();
        while (!InputView.isValidId(movieId, movies)) {
        	System.out.println("상영목록에 없는 영화입니다.");
        	movieId = InputView.inputMovieId();
        }
        // TODO 구현 진행
        ////출력해야대.
        OutputView.printSchedule(movies,movieId);
        
        int timeTableNum = InputView.inputMovieTimeNumber(movieId);
        
    }
    
    void start() {
    	
    }
}
