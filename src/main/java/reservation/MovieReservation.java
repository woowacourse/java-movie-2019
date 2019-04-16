package reservation;

import domain.*;

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

    boolean checkVaildSchedule(PlaySchedule schedule) {
        if (!reservations.stream()
                .allMatch(reservation -> reservation.checkTime(schedule))) {
            System.out.println("기존 예매 목록과 한시간 이상 차이가 납니다.");
            return false;
        }
        return true;
    }

    void insertReserrvation(Movie selectedMovie, PlaySchedule schedule, int reservePeopleNum) {
        reservations.add(new ReservationMovie(selectedMovie.getId(), selectedMovie.getName(), selectedMovie.getPrice(),
                new ReservationSchedule(schedule.getStartDateTime(), reservePeopleNum)));
    }

    public void printResult() {
        for (ReservationMovie reservationMovie : reservations) {
            System.out.println(reservationMovie);
        }
    }
}
