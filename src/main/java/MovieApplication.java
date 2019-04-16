import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    static int total = 0;
    static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = 0;
        do { movieId = InputView.inputMovieId(); }
        while (!selectMovie(movies, movieId));

        int scheduleNumber = selectSchedule(movies.get(movieId-1));

        int peopleNumber = 0;
        do { peopleNumber = InputView.inputPeopleNumber(); }
        while (movies.get(movieId).isCapable(scheduleNumber, peopleNumber));

        reservations.add(new Reservation(movies.get(movieId), scheduleNumber, total));
    }

    public static boolean selectMovie(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if (movie.isSameId(movieId)) {
                System.out.println(movie.toString());
                return true;
            }
        }
        OutputView.printNotExistedMovie();
        return false;
    }

    public static int selectSchedule(Movie movie) {
        int scheduleNumber = InputView.inputMovieSchedule();

        if (!movie.isExistedSchedule(scheduleNumber)) {
            OutputView.printNotExistedSchedule();
            scheduleNumber = selectSchedule(movie);
        }
        return scheduleNumber;
    }

    /*public static Reservation makeReservation(Movie movie, int scheduleNumber, int peopleNumber) {
        int scheduleNumber = InputView.inputMovieSchedule();

        if (!movie.isExistedSchedule(scheduleNumber)) {
            OutputView.printNotExistedSchedule();
            scheduleNumber = selectSchedule(movie);
        }
        return scheduleNumber;
    }*/
}