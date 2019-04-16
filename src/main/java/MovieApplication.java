import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        Movie movie = MovieRepository.getMovieInformation(movieId);
        OutputView.printMovie(movie);

        int moviewTime = InputView.inputMovieTime();
        int movieNum = InputView.inputMovieNum();
        int InputNextStep = InputView.inputNextStep();

        // 예약내역
        System.out.println(movie.numberMovie(moviewTime, movieNum));
        movieprice = movie.getPrice() * movieNum;


        // 결제 진행
        OutputView.outputPaymentStep();

        //포인트
        int point = InputView.inputMoviePoint();

        //신용카드
        int cardcash = InputView.inputCardorCash();

        if(cardcash ==1) { //card
            movieprice -= ((int)(movieprice * 0.05)) ;
        }
        if(cardcash ==2) { //cash
            movieprice -= ((int)(movieprice * 0.02)) ;
        }

        movieprice -= point;

        System.out.println("최종결제한금액은 : " + movieprice + "입니다.");
        OutputView.outputconfirm();
    }
} ////
