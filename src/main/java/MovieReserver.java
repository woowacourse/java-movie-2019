import domain.Movie;
import domain.MovieReservation;
import domain.ReservationCommand;
import view.InputView;

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
            reservations.add(factory.createFromUser());

            if (InputView.inputReservationCommand() == ReservationCommand.STOP) {
                break;
            }
        }
        return reservations;
    }
}
