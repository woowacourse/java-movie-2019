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
        do {
            Movie selectedMovie = getPlaySchedulesOfSelectedMovie();
            PlaySchedule selectedPlaySchedule = getPlayScheduleByNumber(selectedMovie);
            int theNumberOfPerson = getTheNumberOfPeron(selectedPlaySchedule);
            try {
                addReservationList(reservedMovies, new Reservation(selectedMovie, selectedPlaySchedule,
                        theNumberOfPerson));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while (checkAdditionalReservationOrNot() == 2);

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
            int scheduleId = InputView.inputMovieScheduleNumber();
            return selectedMovie.getPlaySchedules().get(scheduleId-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getPlayScheduleByNumber(selectedMovie);
        }
    }

    private static int getTheNumberOfPeron(PlaySchedule playSchedule) {
        try {
            int theNumberOfPerson = InputView.inputTheNumberOfPerson();
            playSchedule.checkPersonOverCapacity(theNumberOfPerson);
            return theNumberOfPerson;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getTheNumberOfPeron(playSchedule);
        }
    }

    private static void addReservationList(List<Reservation> reservationList, Reservation curReservation) {
        for (Reservation reservation : reservationList) {
            curReservation.checkOneHourGap(reservation);
        }
        reservationList.add(curReservation);
    }

    private static int checkAdditionalReservationOrNot() {
        try {
            int checkReservationEnd = InputView.inputAdditionalReserveOrNot();
            if (checkReservationEnd != 1 && checkReservationEnd != 2) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
            return checkReservationEnd;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return checkAdditionalReservationOrNot();
        }
    }
}
