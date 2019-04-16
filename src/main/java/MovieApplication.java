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
        while (restart == Constant.CONTINUE_NUM) {
            onceTicketing();
            restart = Input.restartInput();
        }
        OutputView.printTicketHistory(selectMovieList);
        payment(selectMovieList);
    }

    public static void onceTicketing() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        int movieId = Input.idInput();
        Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
        OutputView.printSelectedMovie(selectedMovie);
        int movieTime = Input.timeInput(selectedMovie);
        int peopleNum = Input.peopleInput(selectedMovie, movieTime);
        SelectMovie completeMovie = new SelectMovie(selectedMovie, movieTime, peopleNum);
        selectMovieList.add(completeMovie);
    }

    public static void payment(List<SelectMovie> movieList) {
        OutputView.paymentRequest();
        int sumPrice = getSumPrice(movieList);
        int usePoint = Input.pointInput(sumPrice);
    }

    public static int getSumPrice(List<SelectMovie> movieList) {
        int price=0;
        for(SelectMovie movie: movieList){
            price += movie.getOneMovieSumPrice();
        }
        return price;
    }

}
