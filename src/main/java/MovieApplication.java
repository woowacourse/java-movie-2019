import domain.Movie;
import domain.MovieRepository;

import input.ScheduleInput;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        Movie movie = InputView.inputMovie(movies);
        ScheduleInput scheduleInput = new ScheduleInput(movie,"");
        // TODO 구현 진행
        System.out.println(scheduleInput.scheduleIdIs());

    }
}
