import domain.Movie;
import domain.MovieRepository;
import utils.Constant;
import view.InputView;
import view.OutputView;
import utils.Input;
import domain.SelectMovie;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {

    static int restart = Constant.CONTINUE_NUM;
    static List<SelectMovie> selectMovieList = new ArrayList<>();

    public static void main(String[] args) {
        List<Movie> allMovie = MovieRepository.getMovies();
        while (restart == Constant.CONTINUE_NUM) {
            onceTicketing(allMovie);
            restart = Input.restartInput();
        }
        OutputView.printTicketHistory(selectMovieList);
        payment(selectMovieList);
    }

    public static void onceTicketing(List<Movie> movies) {
        OutputView.printMovies(movies);
        int movieId = Input.idInput();
        Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
        OutputView.printSelectedMovie(selectedMovie);
        int movieTime = Input.timeInput(selectedMovie);
        int peopleNum = Input.peopleInput(selectedMovie, movieTime);
        completeOnceTicketing(selectedMovie, movieTime, peopleNum);
    }

    public static void completeOnceTicketing(Movie selectedMovie, int movieTime, int peopleNum) {
        selectedMovie.discountScheduleCapacity(movieTime, peopleNum);
        SelectMovie completeMovie = new SelectMovie(selectedMovie, movieTime, peopleNum);
        selectMovieList.add(completeMovie);
    }

    public static void payment(List<SelectMovie> movieList) {
        OutputView.paymentRequest();
        int sumPrice = getSumPrice(movieList);
        int usePoint = Input.pointInput(sumPrice);
        int creditOrCash = Input.creditCashInput();
        OutputView.printResult(sumPrice - usePoint);
    }

    public static int getSumPrice(List<SelectMovie> movieList) {
        int price = 0;
        for (SelectMovie movie : movieList) {
            price += movie.getOneMovieSumPrice();
        }
        return price;
    }

}
