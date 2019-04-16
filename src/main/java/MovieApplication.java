import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        System.out.println(getPlayScheduleOfSelectedMovie());
    }

    private static String getPlayScheduleOfSelectedMovie(){
        try{
            int movieId = InputView.inputMovieId();
            return OutputView.getMoviePlaySchedule(movieId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return getPlayScheduleOfSelectedMovie();
        }
    }
}
