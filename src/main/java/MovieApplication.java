import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
    	int movieId = 0;
    	int movieTime = 0;
    	int ViewNum = 0;
    	int MoviePay = 0;
    	int PointPay = 0;
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
        
        do {
        	ViewNum = InputView.inputMovieViewNum();
        }while(va.ViewNumVaild(SelectMovie, ViewNum)); // 미구현
        do {
        	MoviePay = OutputView.printMovieTicket(SelectMovie, movieTime , ViewNum); 
        	PointPay = InputView.inputPoint();
        }while(va.PaymentVaild(MoviePay,PointPay));
        int payMethod = InputView.inputPayMethod();
        OutputView.printResultPay(payMethod, MoviePay, PointPay);
        
    }
}
