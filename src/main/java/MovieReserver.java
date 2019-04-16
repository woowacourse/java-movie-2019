import domain.Movie;
import domain.MovieReservation;
import domain.ReservationCommand;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieReserver {

    private ReservationFactory factory;

    public MovieReserver(ReservationFactory factory) {
        this.factory = factory;
    }

    public List<MovieReservation> reserveMovies(List<Movie> movies) {
        // 내부에서 영화 관련 정보를 변경하기에 새로 복사했음 (동일 영화를 반복해서 예약할 경우 이전 예약으로 변경된 capacity로 적용해야기에
        movies = new ArrayList(movies);

        List<MovieReservation> reservations = new ArrayList();
        while (true) {
            MovieReservation reservation = factory.createFromUser(movies);

            if (!canAdd(reservations, reservation)) {
                System.out.println("이전에 예약된 시간 중에서 한시간 넘게 차이나는 예약이 존재합니다.");
                continue;
            }

            reservations.add(reservation);
            update(movies, reservation);
            
            if (InputView.inputReservationCommand() == ReservationCommand.STOP) {
                break;
            }
            OutputView.printMovies(movies);
        }
        return reservations;
    }

    private int getMovieIdxByID(List<Movie> movies, int id) {
        for (int idx = 0, n = movies.size(); idx < n; idx++) {
            if (movies.get(idx).hasID(id)) {
                return idx;
            }
        }
        return -1;
    }

    private Movie getMovieByID(List<Movie> movies, int id) {
        return movies.stream().filter(movie -> movie.hasID(id)).findFirst().get();
    }

    private void update(List<Movie> movies, MovieReservation reservation) {
        int movieID = reservation.getID();

        Movie updatedMovie = getMovieByID(movies, movieID);
        updatedMovie.reserve(reservation);

        System.out.println("updated movie: " + updatedMovie.toString());
        movies.set(getMovieIdxByID(movies, movieID), updatedMovie);
    }

    private boolean canAdd(List<MovieReservation> reservations, MovieReservation reservation) {
        long numAreOneHourWithinRange = reservations.stream()
                .filter(r -> r.isOneHourWithinRange(reservation.getTime()))
                .count();

        return reservations.size() == numAreOneHourWithinRange;
    }
}
