import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.LinkedList;
import java.util.List;

public class MovieApplication {

    static List<Movie> books = new LinkedList<>();
    static List<PlaySchedule> schedules = new LinkedList<>();

    static private int people;
    static private int scheduleId;

    public static void main(String[] args) {
        do {
            List<Movie> movies = MovieRepository.getMovies();
            OutputView.printMovies(movies);
            Movie movie = check(movies);
            OutputView.printEachMovie(movie);
            schedules.add(askSchedule(movie));
        } while (askPurchse());
        showBooks();
    }

    public static Movie check(List<Movie> movies) {
        try {
            int movieId = InputView.inputMovieId();
            return findMovie(movies, movieId);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return check(movies);
        }
    }

    public static Movie findMovie(List<Movie> movies, int id) {
        for (Movie each : movies) {
            if (each.movieMatchOf(id)) {
                books.add(each);
                return each;
            }
        }

        throw new IllegalArgumentException("없는 영화표를 선택하셨습니다.");
    }

    public static PlaySchedule askSchedule(Movie movie) {
        try {
            scheduleId = InputView.inputScheduleId() - 1;
            people = InputView.inputPerson();

            return movie.checkSchedue(scheduleId, people);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askSchedule(movie);
        }
    }

    public static boolean askPurchse() {
        return (InputView.inputAgain() != 1);
    }

    public static void showBooks() {
        System.out.print("예약 내역");

        for (Movie each : books) {
            System.out.print(each.showBooks());
        }

        for (PlaySchedule schedule : schedules) {
            System.out.print(schedule.showResult());
        }
    }
}