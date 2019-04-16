import domain.Movie;
import domain.MovieReservation;
import domain.PlaySchedule;
import view.InputView;

import java.util.List;

public class ReservationFactory {

    public MovieReservation createFromUser(List<Movie> movies) {
        int movieId = readValidMovieId();

        Movie movie = getMovieById(movies, movieId);

        System.out.println(movie);

        int idx = InputView.inputMovieStartDateTimeIdx();

        // idx 어떻게 하면 실수하지 않을까?
        PlaySchedule schedule = movie.getPlaySchedules().get(idx - 1);

        int numReserve = readNumReserve();

        return new MovieReservation(movieId, movie.getPrice(), schedule.getStartDateTime(), numReserve);
    }

    private Movie getMovieById(List<Movie> movies, int id) {
        for (Movie movie: movies) {
            if (movie.hasID(id)) {
                return movie;
            }
        }
        // 오면 안됨
        assert false;
        return movies.get(0);
    }

    private int readValidMovieId() {

        return InputView.inputMovieId();
    }

    private int readTimeIdx() {
        return InputView.inputMovieStartDateTimeIdx();
    }

    private int readNumReserve() {
        return InputView.inputNumReserve();
    }
}
