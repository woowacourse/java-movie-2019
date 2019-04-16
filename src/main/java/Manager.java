import domain.Movie;
import domain.MovieRepository;
import domain.UserMovie;
import utils.MyUtil;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Manager {
    private InputError inputError;
    private MyUtil myUtil;
    private List<Movie> movies;
    private int movieId;
    private int timeId;
    private int peopleCount;

    Manager(){
        inputError = new InputError();
        myUtil = new MyUtil();
    }

    public void startReserve(){
        // 유저무비 변수 초기화
        this.movies = MovieRepository.getMovies();
        System.out.println("## 상영 영화 목록");
        OutputView.printMovies(movies);

        while(!firstQuery());

        OutputView.printIdMovie(movies, movieId);

        while(!secondQuery());

        while(!thirdQuery())
    }

    public boolean thirdQuery(){
        peopleCount = InputView.inputPeopleCount();
    }

    public boolean firstQuery(){
        movieId = InputView.inputMovieId();
        if(!inputError.checkContainId(movies, movieId)){
            return false;
        }
        return true;
    }

    public boolean secondQuery(){
        timeId = InputView.inputTimetable();
        if(!inputError.checkContainTimeIndex(movies, movieId, timeId)){
            return false;
        }
        return true;
    }
}
