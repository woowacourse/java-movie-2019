package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Reservation {
    private List<Movie> movies;
    private Movie movie;
    private PlaySchedule schedule;
    private int reservationCount;

    public Reservation(List<Movie> movies) {
        this.movies = movies;
        OutputView.printMovies(this.movies);
        int movieId = InputView.inputMovieId();
        movie = OutputView.selectMovie(movies, movieId);
        OutputView.printMovie(movie);
        int scheduleId = InputView.inputScheduleId();
        schedule = movie.getPlaySchedule(scheduleId);
        reservationCount = InputView.inputReservationCount();
        schedule.scheduleReservation(reservationCount);
    }

    @Override
    public String toString() {
        return movie.getName() + schedule.getStartTimeString() + "예약 인원: "
                + reservationCount + "명\n";
    }
}
