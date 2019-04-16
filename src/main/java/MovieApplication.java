import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieApplication {
    static private final List<Movie> movies = MovieRepository.getMovies();
    static private final List<Movie> booked = new ArrayList<>();

    public static void main(String[] args) {
        Movie movie;

        PlaySchedule schedule;
        int capacity;
        int choice;

        OutputView.printMovies(movies);

        movie = getMovieById(InputView.inputMovieId());
        System.out.println(movie);

        schedule = validateSchedule(movie, InputView.inputSchedule());

        System.out.println("\n");
        capacity = validateCapacity(schedule, InputView.inputCapacity());

        System.out.println("\n");
        choice = InputView.inputPayOrRepeatMenu();

    }

    private static Movie getMovieById(int id) {
        Optional<Movie> movie = movies.stream().filter(x -> x.getId() == id).findFirst();

        if (movie.isPresent()) {
            return movie.get();
        }
        OutputView.printNoMovieMessage();
        return getMovieById(InputView.inputMovieId());
    }

    private static PlaySchedule validateSchedule(Movie movie, int no) {
        Optional<PlaySchedule> schedule = movie.getScheduleByNumber(no);

        if (schedule.isPresent()) {
            return validateScheduleTime(movie, schedule.get());
        }
        OutputView.printNoScheduleMessage();
        return validateSchedule(movie, InputView.inputSchedule());
    }

    private static PlaySchedule validateScheduleTime(Movie movie, PlaySchedule schedule) {
        if (schedule.isNotStartedYet()) {
            return schedule;
        }
        OutputView.printAlreadyStartedMessage();
        return validateSchedule(movie, InputView.inputSchedule());
    }

    private static int validateCapacity(PlaySchedule schedule, int capacity) {
        if (1 <= capacity && capacity <= schedule.getCapacity()) {
            schedule.book(capacity);
            return capacity;
        }
        OutputView.printNotEnoughCapacityMessage();
        return validateCapacity(schedule, InputView.inputCapacity());
    }
}