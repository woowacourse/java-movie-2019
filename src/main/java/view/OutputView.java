package view;

import java.util.List;

import domain.Movie;
import domain.SelectedMovie;

public class OutputView {
    public static boolean printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
        return true;
    }
    
    public static boolean printSelectedMovies(List<SelectedMovie> selectedMovies) {
        for (SelectedMovie selectedMovie : selectedMovies) {
            System.out.println(selectedMovie);
        }
        return true;
    }
}
