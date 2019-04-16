import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {

    public static void showAllReservation(List<MovieReservation> reservationList) {
        // 지금까지 예약내역 보여주기
        for (int i = 0; i < reservationList.size(); i++) {
            MovieReservation reserveInfo = reservationList.get(i);
            Movie movie = MovieRepository.getMovie(reserveInfo.getMovieId());
            PlaySchedule playSchedule = movie.getSchedule(reserveInfo.getScheduleIndex());
            int printPersonCount = reserveInfo.getPersonCount();

            System.out.println("예약 내역");
            movie.showBasicInfo();
            playSchedule.showOnlyTimeInfo();
            System.out.println("예약인원:" + printPersonCount + "명");
        }
    }

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
    }
}
