package view;

import domain.Movie;

import java.util.List;

public class OutputView {
	private static final String PRINT_MOVIES_MESSAGE = "## 상영 영화 목록";
	
    public static void printMovies(List<Movie> movies) {
    	System.out.println(PRINT_MOVIES_MESSAGE);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
