import domain.Booker;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    Booker bookProcessing(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Booker booker = new Booker();

        do {
            booker.selectMovie();
            OutputView.printMovie(booker.currentBookingMovieId());
            booker.selectBookingTime();
            booker.selectBookingNumber();
        }while(!InputView.inputPayProcessing());

        return booker;
    }

    void processOfPayment(Booker booker){
        OutputView.printResultBooking(booker);
    }

    public static void main(String[] args) {
        MovieApplication movieApplication = new MovieApplication();
        Booker booker;

        booker = movieApplication.bookProcessing();
        movieApplication.processOfPayment(booker);
    }
}
