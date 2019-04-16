import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
    	int movieId = 0;
    	int movieTime = 0;
        List<Movie> movies = MovieRepository.getMovies();
        domain.Vaild va = new domain.Vaild();
        OutputView.printMovies(movies);
        
        do {
        	movieId = InputView.inputMovieId();
        }while(va.movieNumVaild(movieId));
        Movie SelectMovie = OutputView.printSelectMovie(movies, movieId);
        do {
        	movieTime = InputView.inputMovieTime();
        }while(va.movieTimeVaild(SelectMovie, movieTime));
        int ViewNum = InputView.inputMovieViewNum();
        int MoviePay = OutputView.printMovieTicket(SelectMovie, movieTime , ViewNum); 
        int PointPay = InputView.inputPoint();
        va.PaymentVaild(MoviePay,PointPay);
        int payMethod = InputView.inputPayMethod();
        OutputView.printResultPay(payMethod, MoviePay, PointPay);
        
    }
}
