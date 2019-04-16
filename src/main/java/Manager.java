import domain.Movie;
import domain.MovieRepository;
import utils.MyUtil;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Manager {
    private InputError inputError;
    private MyUtil myUtil;
    private List<Movie> movies;

    Manager(){
        inputError = new InputError();
        myUtil = new MyUtil();
    }

    public void startReserve(int movieId){
        this.movies = MovieRepository.getMovies();

        while(true){
            if(inputError.checkContainId(this.movies, movieId)) {
                break;
            }
            movieId = InputView.inputMovieId();
        }
        OutputView.printIdMovie(movies, movieId);
    }
}
