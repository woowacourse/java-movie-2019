import domain.Movie;
import domain.MovieReservation;
import domain.PlaySchedule;
import view.InputView;

import java.util.List;

public class ReservationFactory {

    public MovieReservation createFromUser(List<Movie> movies) {
        int movieId = readValidMovieId(movies);
        Movie movie = getMovieById(movies, movieId);

        System.out.println(movie.toString());

        int idx = readValidScheduleIdx(movie);
        PlaySchedule schedule = movie.getPlaySchedule(idx);

        int numReserve = readValidNumReserve(schedule);

        return new MovieReservation(movieId, movie.getPrice(), schedule.getStartDateTime(), numReserve);
    }

    // 현재 존재하는 id여야함
    private Movie getMovieById(List<Movie> movies, int id) {
        return movies.stream().filter(movie -> movie.hasID(id)).findFirst().get();
    }

    private boolean isValidMovieId(List<Movie> movies, int id) {
        return 0 < movies.stream().filter(movie -> movie.hasID(id)).count();
    }

    private int readValidMovieId(List<Movie> movies) {
        int id = InputView.inputMovieId();
        if (!isValidMovieId(movies, id)) {
            System.out.println("존재하지 않는 영화 id입니다.");
            return readValidMovieId(movies);
        }
        return id;
    }

    private boolean isValidScheduleIdx(Movie movie, int idx) {
        if (idx < 0) return false;
        return movie.canAccessSchedule(idx);
    }

    private int readValidScheduleIdx(Movie movie) {
        int idx = InputView.inputMovieStartDateTimeIdx() - 1;
        if (!isValidScheduleIdx(movie, idx)) {
            System.out.println("존재하지 않는 시간표 입니다. ");
            return readValidScheduleIdx(movie);
        }
        return idx;
    }

    private boolean isValidNumReserve(PlaySchedule schedule, int numReserve) {
        if (numReserve <= 0) return false;
        return !schedule.isOverCapacity(numReserve);
    }

    private int readValidNumReserve(PlaySchedule schedule) {
        int numReserve = InputView.inputNumReserve();
        if (!isValidNumReserve(schedule, numReserve)) {
            System.out.println("예약할 수 있는 인원을 초과하셨습니다. ");
            return readValidNumReserve(schedule);
        }
        return numReserve;
    }
}
