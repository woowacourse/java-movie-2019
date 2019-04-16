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
    private List<Movie> movies;
    private List<Movie> bookedMovies;

    public BookMovie() {
        movies = MovieRepository.getMovies();
        bookedMovies = new ArrayList<>();
        showMovieList();
    }

    public void run() {
        try {

            getMovieSchedule(getSelectedMovie());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            run();
        }
    }

    private void showMovieList() {
        OutputView.printMovies(movies);
    }

    private Movie getSelectedMovie() {
        int movieId = InputView.inputMovieId();
        for (Movie m : movies) {
            if (m.getMovieId() == movieId) {
                return m;
            }
        }
        throw new IllegalArgumentException("해당하는 영화가 없습니다.");
    }

    private void getMovieSchedule(Movie movie) {
        PlaySchedule schedule = movie.getMovieSchedule(InputView.inputMovieTime() - 1);
        checkMovieTime(schedule.getStartDateTime());
        checkCustomerCount(schedule);
        bookedMovies.add(movie);
    }

    private void checkMovieTime(LocalDateTime startTime) {
        if (DateTimeUtils.isEarlyerThanMovieTime(startTime)) {
            throw new IllegalArgumentException("상영시간이 이미 지났습니다.");
        }
    }

    private void checkCustomerCount(PlaySchedule schedule) {
        if (InputView.inputMovieCustomer() > schedule.getCapacity()) {
            throw new IllegalArgumentException("인원 초과입니다.");
        }
    }

}
