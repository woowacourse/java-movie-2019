import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        MovieRepository movierep = new MovieRepository();
        Movie movie;
        OutputView.printMovies(movies);
        int movieId;
        int movieScheduleId;
        
        do {
        	movieId = InputView.inputMovieId();
		} while ((movie = movierep.isMovie(movieId)) == null);
        
        System.out.println(movie.toString());
        
        do {
        	movieScheduleId = InputView.inputSchedule();
        } while (!movie.isValidSchedule(movieScheduleId));
        
    }
}
