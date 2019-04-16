import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    static int total = 0;
    static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        /**** 예약 영화 ****/
        int movieId = 0;
        do { movieId = InputView.inputMovieId(); }
        while (!selectMovie(movies, movieId));

        /**** 예약 스케줄 ****/
        int scheduleIndex = selectSchedule(movies.get(movieId-1));

        /**** 예약 인원 ****/
        int peopleNumber = putPeopleNum(movies.get(movieId-1), scheduleIndex);

        // Reservation 객체 생성하고
        // reservations 리스트랑 모두 1시간 이내인지 확인해봐


        reservations.add(new Reservation(movies.get(movieId), scheduleIndex, total));
        OutputView.printReservation(reservations);
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
        return scheduleIndex;
    }

    public static int putPeopleNum(Movie movie, int scheduleIndex) {
        int peopleNumber = InputView.inputPeopleNumber();

        if (!movie.isCapable(scheduleIndex, peopleNumber)) {
            OutputView.printExceededCapacity();
            peopleNumber = putPeopleNum(movie, scheduleIndex);
        }
        return peopleNumber;
    }

    /*public static Reservation makeReservation(Movie movie, int scheduleNumber, int peopleNumber) {
        int scheduleNumber = InputView.inputMovieSchedule();

        if (!movie.isExistedSchedule(scheduleNumber)) {
            OutputView.printNotExistedSchedule();
            scheduleNumber = selectSchedule(movie);
        }
        return scheduleNumber;
    }*/
}