package reservation;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import view.InputView;

public class ReservationMain {
    public static MovieReservation reservationRun(MovieReservation reservations) {
        int reservePeopleNum;
        int movieId = InputView.inputMovieId();

        Movie selectedMovie = ReservationCreater.inputMovie(movieId);
        PlaySchedule schedule = ReservationCreater.inputSchedule(reservations, selectedMovie);
        reservePeopleNum = ReservationCreater.inputReserveNum(schedule);
        reservations.insertReserrvation(selectedMovie, schedule, reservePeopleNum);
        MovieRepository.reduceCapacity(selectedMovie, schedule, reservePeopleNum);
        return reservations;
    }
}
