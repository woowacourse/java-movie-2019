import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
	public static Movie addMovie() {
		List<Movie> movies = MovieRepository.getMovies();
        MovieRepository movierep = new MovieRepository();
        Movie movie;
        OutputView.printMovies(movies);
        int movieId;
        int movieScheduleId;
        int peopole;
        
        do {
        	movieId = InputView.inputMovieId();
		} while ((movie = movierep.isMovie(movieId)) == null);
        OutputView.printMovie(movie);
        
        do {
        	movieScheduleId = InputView.inputSchedule();
        } while (!movie.isValidSchedule(movieScheduleId));
        
        do {
        	peopole = InputView.inputPeople();
        } while (!movie.isValidCapacity(movie.getPlaySchedule(), peopole));
		
        return movie;
	}
	
	public static void main(String[] args) {
		List<Movie> MyMovies = new ArrayList<>();
		int morePurchase;
		
        do {
        	MyMovies.add(addMovie());
        	morePurchase = InputView.inputMorePurchase();
		} while (morePurchase == 2);
		
        OutputView.printPurchaseMovies(MyMovies);
    }
}
