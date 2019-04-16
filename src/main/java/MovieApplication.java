import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;
import utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    static int total = 0;
    static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        do {
            /**** 예약 영화 ****/
            int movieId = 0;
            do { movieId = InputView.inputMovieId(); }
            while (!selectMovie(movies, movieId));

            /**** 예약 스케줄 ****/
            int scheduleIndex = selectSchedule(movies.get(movieId-1));

            /**** 예약 인원 ****/
            int peopleNumber = putPeopleNum(movies.get(movieId-1), scheduleIndex);

            Reservation reservation = makeReservation(movies.get(movieId-1), scheduleIndex, peopleNumber);
            reservations.add(reservation);
        } while (InputView.isContinued());

        OutputView.printReservation(reservations);

        int point = InputView.inputPoint();
        boolean payment = InputView.inputPayment();
    }

    public static boolean selectMovie(List<Movie> movies, int movieId) {
        for (Movie movie : movies) {
            if (movie.isSameId(movieId)) {
                System.out.println(movie.toString());
                return true;
            }
        }
        OutputView.printNotExistedMovie();
        return false;
    }

    public static int selectSchedule(Movie movie) {
        int scheduleIndex = InputView.inputMovieSchedule();

        if (!movie.isExistedSchedule(scheduleIndex)) {
            OutputView.printNotExistedSchedule();
            scheduleIndex = selectSchedule(movie);
        }
        if (!isOneHourWithinRange(movie, scheduleIndex)) {
            OutputView.printIsNotOneHourWithinRange();
            scheduleIndex = selectSchedule(movie);
        }
        return scheduleIndex;
    }

    public static boolean isOneHourWithinRange(Movie movie, int index) {
        LocalDateTime localDateTime = movie.getPlaySchedule(index).getStartDateTime();

        for (Reservation reservation : reservations) {
            if (!DateTimeUtils.isOneHourWithinRange(localDateTime, reservation.getScheduleTime()))
                return false;
        }
        return true;
    }

    public static int putPeopleNum(Movie movie, int scheduleIndex) {
        int peopleNumber = InputView.inputPeopleNumber();

        if (!movie.isCapable(scheduleIndex, peopleNumber)) {
            OutputView.printExceededCapacity();
            peopleNumber = putPeopleNum(movie, scheduleIndex);
        }
        return peopleNumber;
    }

    public static Reservation makeReservation(Movie movie, int scheduleIndex, int peopleNumber) {
        return new Reservation(movie, scheduleIndex, peopleNumber);
    }

}