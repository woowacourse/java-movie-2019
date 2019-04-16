import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

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
	
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        


        
    }
}
