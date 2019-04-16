import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
    	
        List<Movie> movies = MovieRepository.getMovies();
        domain.Vaild va = new domain.Vaild();
        OutputView.printMovies(movies);
        
        int movieId = InputView.inputMovieId(); // 보고 싶은 영화의 숫자 입력 받음
        Movie SelectMovie = OutputView.printSelectMovie(movies, movieId);
        int movieTime = InputView.inputMovieTime();
        int ViewNum = InputView.inputMovieViewNum();
        int MoviePay = OutputView.printMovieTicket(SelectMovie, movieTime , ViewNum); 
        int PointPay = InputView.inputPoint();
        va.PaymentVaild(MoviePay,PointPay);
        int payMethod = InputView.inputPayMethod();
        OutputView.printResultPay(payMethod, MoviePay, PointPay);
        
    }
}
