package view;

import java.util.List;

import domain.Movie;
import domain.MovieRepository;

public class OutputView {
	public static void printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void printMovie(int movieId) {
		System.out.println(MovieRepository.getMovieById(movieId));
	}
}
