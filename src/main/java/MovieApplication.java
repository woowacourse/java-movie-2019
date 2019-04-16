import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<Movie> MyMovies = new ArrayList<>();
        MovieRepository movierep = new MovieRepository();
        Movie movie;
        OutputView.printMovies(movies);
        int movieId;
        int movieScheduleId;
        int peopole;
        PlaySchedule playSchedule;
        
        do {
        	movieId = InputView.inputMovieId();
		} while ((movie = movierep.isMovie(movieId)) == null);
        movies.add(movie);
        OutputView.printMovie(movie);
        
        do {
        	movieScheduleId = InputView.inputSchedule();
        } while (!movie.isValidSchedule(movieScheduleId));
        
        do {
        	peopole = InputView.inputPeople();
        } while (!movie.isValidCapacity(movie.getPlaySchedule(), peopole));
        
    }
}
