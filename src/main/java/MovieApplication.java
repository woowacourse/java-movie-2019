import domain.Movie;
import domain.MovieRepository;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        BookControl control = new BookControl(movies);
        do {
            control.bookMovie();
        } while(control.checkMoreBook());
        control.printBookedMovies();
        control.purchaseMovieTickets();
    }
}
