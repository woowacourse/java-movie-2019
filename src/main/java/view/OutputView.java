package view;

import domain.Movie;

import java.util.List;

public class OutputView {
	
	private static int movieNum;
	private static final int BIRTHDAY = InputView.BIRTHDAY;
	private static final int MONEY = InputView.MONEY;
	private static final int FIVE_FEET = InputView.FIVE_FEET;
	private static final int FIRST_MOVIE = 0;
	private static final int SECOND_MOVIE = 1;
	private static final int THRID_MOVIE = 2;
	private static final int FOURTH_MOVIE = 3;
	
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    
    public static void printSelectedMovies(List<Movie> movies, int movieId) {
    	for (int i = 0; i < movies.size(); i++) {
    	    movieNum = checkMovieNumber(movies, movieId);   
    	}
    	System.out.println(movies.get(movieNum));
    }
    
    private static int checkMovieNumber(List<Movie> movies, int movieId) {
    	return (movieId == BIRTHDAY ? FIRST_MOVIE
    		: movieId == MONEY ? SECOND_MOVIE
			: movieId == FIVE_FEET ? THRID_MOVIE
			:                FOURTH_MOVIE);
    }
}
