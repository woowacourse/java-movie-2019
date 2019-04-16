package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class OutputView {
	
	public static void printMovie(int movieId) {
		Movie movie = MovieRepository.getMovie(movieId); 
		System.out.println(movie);
	}
    
	public static void printMovies(List<Movie> movies) {
    	System.out.println("## 상영 영화 목록");
        
    	for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
