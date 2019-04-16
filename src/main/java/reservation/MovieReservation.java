package reservation;

import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.ReservationMovie;

import java.util.ArrayList;

public class MovieReservation {
    private ArrayList<ReservationMovie> reservations = new ArrayList<>();

    public static int checkExistList(int movieId) {
        if (!MovieRepository.contain(movieId)) {
            throw new IllegalArgumentException();
        }
        return movieId;
    }

    public static PlaySchedule checkExistSchedule(Movie selectedMovie, int ScheduleId) {
        return selectedMovie.checkVaildSchedule(ScheduleId);
    }

    public boolean checkVaildSchedule(PlaySchedule schedule) {
        return reservations.stream()
                .allMatch(reservation -> reservation.checkTime(schedule));
    }
}
