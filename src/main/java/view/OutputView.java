package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class OutputView {
	public static void printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	// TODO indent 줄이기
	public static void printMovie(int movieId) {
		for(Movie movie : MovieRepository.getMovies()) {
			if(movie.getId() == movieId) {
				System.out.println(movie);
			}
		}
		
	}
}
