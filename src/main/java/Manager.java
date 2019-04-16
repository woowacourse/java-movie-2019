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
        while(!reserveProcess());
        //printResult
    }

    public boolean reserveProcess(){
        System.out.println("## 상영 영화 목록");
        OutputView.printMovies(movies);
        while(!firstQuery());
        OutputView.printIdMovie(movies, movieId);
        while(!secondQuery());
        while(!thirdQuery());
        while(!fourthQuery());
    }

    public boolean fourthQuery(){
        int ret = InputView.inputIsEndOrNot();
        if(!inputError.checkOneTwo(ret)){
            return false;
        }
        return true;
    }

    public boolean thirdQuery(){
        peopleCount = InputView.inputPeopleCount();
        if(!inputError.CheckMinusError(movieId)){
            return false;
        }
        return true;
    }

    public boolean firstQuery(){
        movieId = InputView.inputMovieId();
        if(!inputError.CheckMinusError(movieId) || !inputError.checkContainId(movies, movieId)){
            return false;
        }
        return true;
    }

    public boolean secondQuery(){
        timeId = InputView.inputTimetable();
        if(!inputError.CheckMinusError(timeId) || !inputError.checkContainTimeIndex(movies, movieId, timeId)){
            return false;
        }
        return true;
    }
}
