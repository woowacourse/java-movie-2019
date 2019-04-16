import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 영화 예매 어플리케이션이 실행되는 main 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/16
 */
public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        //TODO 상영시간이 지났는지 여부 확인

        List<Reservation> reservedMovies = new ArrayList<>();
        do{
            Movie selectedMovie = getPlaySchedulesOfSelectedMovie();
            selectMovieSchedule(reservedMovies, selectedMovie);
        }while(checkAdditionalReserveOrNot() == 2);
        OutputView.printReservation(reservedMovies);
    }

    private static Movie getPlaySchedulesOfSelectedMovie() {
        try {
            int movieId = InputView.inputMovieId();
            return OutputView.getMoviePlaySchedule(movieId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPlaySchedulesOfSelectedMovie();
        }
    }

    private static PlaySchedule getPlayScheduleByNumber(Movie selectedMovie) {
        try {
            int scheduleId = InputView.inputMovieScheduleNumber();             // 시간표 선택
            return selectedMovie.getPlaySchedules().get(scheduleId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPlayScheduleByNumber(selectedMovie);
        }
    }

    /* 영화 선택이후 결제 전까지의 영화 선택 과정을 담은 메소드 */
    private static List<Reservation> selectMovieSchedule(List<Reservation> reservedMovies, Movie movie) {
        try {
            PlaySchedule selectedPlaySchedule = getPlayScheduleByNumber(movie);
            int theNumberOfPerson = InputView.inputTheNumberOfPerson();
            selectedPlaySchedule.checkPersonOverCapacity(theNumberOfPerson);
            reservedMovies.add(new Reservation(movie, selectedPlaySchedule, theNumberOfPerson));
            return reservedMovies;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return selectMovieSchedule(reservedMovies, movie);
        }
    }

    private static int checkAdditionalReserveOrNot() {
        try {
            int checkReservationEnd = InputView.inputAdditionalReserveOrNot();
            if (checkReservationEnd != 1 && checkReservationEnd != 2) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
            return checkReservationEnd;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return checkAdditionalReserveOrNot();
        }
    }
}
