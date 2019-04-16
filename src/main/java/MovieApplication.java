import domain.Movie;
import domain.MovieRepository;
import domain.TicketingManager;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        TicketingManager ticketingManager = new TicketingManager();
        
        OutputView.printMovies(movies);
        ticketingManager.ticketing();
    }
}
