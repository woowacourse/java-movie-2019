import domain.Movie;
import domain.MovieRepository;
import domain.TicketingManager;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        TicketingManager ticketingManager = new TicketingManager();
        int paymentOrAddTicket;
        
        OutputView.printMovies(movies);
        do {
        	ticketingManager.ticketing();
        	paymentOrAddTicket = InputView.inputPaymentOrAddTicket();
        } while (paymentOrAddTicket == 2);
    }
}
