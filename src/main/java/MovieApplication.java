import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId;
        do {
            movieId = InputView.inputMovieId();
        }
        while (!MovieRepository.isContains(movieId));

        OutputView.printMovieById(movieId);

        int scheduledNumber;
        do {
            scheduledNumber = InputView.inputMovieSchedule();
        }
        while (scheduledNumber > movies.get(movieId).getScheduleSize()
                || MovieRepository.getMovieById(movieId).getPlaySchedule().get(scheduledNumber-1).getCapacity() <= 0);



    }

}
