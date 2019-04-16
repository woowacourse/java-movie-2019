import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookMovie {
    List<Movie> movies;
    List<Movie> bookedMovies;

    public BookMovie(){
        movies = MovieRepository.getMovies();
        bookedMovies = new ArrayList<>();
        showMovieList();
    }

    public void run(){
        showMovieList();
        getMovieTime(getSelectedMovie());
    }

    private void showMovieList(){
        OutputView.printMovies(movies);
    }

    private Movie getSelectedMovie() {
        int movieId = InputView.inputMovieId();
        for (Movie m : movies){
            if (m.getMovieId() == movieId){
                return m;
            }
        }
        throw new IllegalArgumentException("해당하는 영화가 없습니다.");
    }

    private void getMovieTime(Movie movie){
        PlaySchedule schedule = movie.getMovieSchedule(InputView.inputMovieTime()-1);
        if (checkMovieTime(schedule.getStartDateTime())){
            throw new IllegalArgumentException("상영시간이 이미 지났습니다.");
        }

        bookedMovies.add(movie);
    }

    private boolean checkMovieTime(LocalDateTime startTime){
        return !DateTimeUtils.isEarlyerThanMovieTime(startTime);
    }

}
