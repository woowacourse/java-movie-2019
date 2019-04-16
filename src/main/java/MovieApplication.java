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
        while(restart == Constant.CONTINUE_NUM){
            stage();
            restart = Input.restartInput();
        }
        OutputView.printTicketHistory(selectMovieList);

    }

    public static void stage(){
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        int movieId = Input.idInput();
        Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
        OutputView.printSelectedMovie(selectedMovie);
        int movieTime = Input.timeInput(selectedMovie);
        int peopleNum = Input.peopleInput(selectedMovie,movieTime);
        SelectMovie completeMovie = new SelectMovie (selectedMovie, movieTime, peopleNum);
        selectMovieList.add(completeMovie);
    }

}
