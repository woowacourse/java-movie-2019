package view;

import java.util.ArrayList;
import java.util.List;

import domain.Movie;
import domain.PlaySchedule;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

	public static void printSchedule(List<Movie> movies,int movieId) {
		List<PlaySchedule> schedule = getMovie(movies,movieId).getPlaySchedule();
		for (PlaySchedule playSchedule : schedule) {
			System.out.print(playSchedule);
		}
	}

	private static Movie getMovie(List<Movie> movies,int movieId) {
		Movie res = null;
		
		for (Movie movie : movies) {
			if (movie.haveId(movieId)) {
				res = movie;
			}
		}
		
		return res;
	}
}
