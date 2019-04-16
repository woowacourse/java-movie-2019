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
        init(movies);
    }

    private void init(List<Movie> movies) {
        try { // TODO: 두 영화의 시간 차이가 1시간 이내가 아닌 경우를 체크.
            this.movies = movies;
            OutputView.printMovies(this.movies);
            int movieId = InputView.inputMovieId();
            movie = OutputView.selectMovie(movies, movieId);
            OutputView.printMovie(movie);
            int scheduleId = InputView.inputScheduleId();
            schedule = movie.getPlaySchedule(scheduleId);
            reservationCount = InputView.inputReservationCount();
            schedule.scheduleReservation(reservationCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            init(movies);
        }
    }

    @Override
    public String toString() {
        return movie.getName() + schedule.getStartTimeString() + "예약 인원: "
                + reservationCount + "명\n";
    }

    public int getPaymentAmount() {
        return movie.getPrice() * reservationCount;
    }
}
