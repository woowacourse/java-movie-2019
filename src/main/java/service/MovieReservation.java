package service;

import domain.*;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieReservation {
    private static final int RE_RESERVATION = 2;
    private static final String OVER_CAPACITY_ERROR_MESSAGE = "예약가능 인원이 초과 하였습니다.";
    private static final String ALREADY_START_MOVIE_ERROR_MESSAGE = "이미 영화가 시작되었습니다.";
    private static final String NOT_EXISTENCE_TIME = "없는 영화시간 입니다.";
    private static final String OVERLAP_MOVIE_TIME_ERROR_MESSAGE = "한시간 내 예약된 영화가 있습니다.";
    private static final String NOT_IN_LIST_ERROR_MESSAGE = "상영목록에 없는 영화입니다.";
    private static final String PAYMENT_MESSAGE = "\n## 결제를 진행합니다.";
    private static final String RESULT_FORMAT = "최종 결제 금액은 %.0f원 입니다.";
    private static final String ENJOY_MOVIE_MESSAGE = "예매를 완료했습니다. 즐거운 영화 관람되세요.";


    public void run() {
        Customer customer = new Customer();

        reservation(customer);
        payMent(customer);
    }

    private void payMent(Customer customer) {
        System.out.println(PAYMENT_MESSAGE);
        int point = InputView.inputPoint();
        int payMentType = InputView.inputPaymentType();
        double result = customer.payment(point, payMentType);

        System.out.println(String.format(RESULT_FORMAT, result));
        System.out.println(ENJOY_MOVIE_MESSAGE);
    }

    private List<Boolean> getBookedTimeResult(List<LocalDateTime> bookedMovieTime, LocalDateTime movieTime) {
        List<Boolean> result = new ArrayList<>();

        for (LocalDateTime localDateTime : bookedMovieTime) {
            if (DateTimeUtils.isOneHourWithinRange(movieTime, localDateTime)) {
                result.add(true);
            }
        }

        return result;
    }

    private boolean isWithInOneHour(int movieId, int movieSchedule, Customer customer) {
        LocalDateTime movieTime = MovieRepository.selectTime(movieId, movieSchedule);
        List<LocalDateTime> bookMovieTime = customer.getBookedTime();
        List<Boolean> resultList = getBookedTimeResult(bookMovieTime, movieTime);
        boolean result = resultList.contains(true);

        if (result) {
            System.err.println(OVERLAP_MOVIE_TIME_ERROR_MESSAGE);
        }

        return result;
    }

    private void reservation(Customer customer) {
        boolean isReplay = true;

        while (isReplay) {
            isReplay = reservationPlay(customer, isReplay);
        }
    }

    private boolean reservationPlay(Customer customer, boolean isReplay) {
        List<Movie> movies = MovieRepository.getMovies();
        Reservation reservation;

        OutputView.printMovies(movies);
        reservation = getReservationMovie(customer, movies);
        customer.reservation(reservation);
        isReplay = checkNext();
        System.out.println(reservation.toString());

        return isReplay;
    }

    private boolean checkNext() {
        int select = InputView.inputSelectNext();
        return select == RE_RESERVATION;
    }

    private boolean checkCapacity(int people, int movieId, int movieSchedule) {
        if (people > MovieRepository.selectCapacity(movieId, movieSchedule)) {
            System.out.println(MovieRepository.selectCapacity(movieId, movieSchedule));
            System.err.println(OVER_CAPACITY_ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private boolean isLateTime(int movieId, int movieSchedule) {
        LocalDateTime movieTime = MovieRepository.selectTime(movieId, movieSchedule);

        if (LocalDateTime.now().isAfter(movieTime)) {
            System.err.println(ALREADY_START_MOVIE_ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private boolean validScheduleSize(int movieId, int movieSchedule) {
        if (MovieRepository.getScheduleSize(movieId) < movieSchedule) {
            System.err.println(NOT_EXISTENCE_TIME);
            return true;
        }

        return false;
    }

    private int selectMovieTime(int movieId, Customer customer) {
        int movieSchedule = InputView.inputMovieTime();

        if (validScheduleSize(movieId, movieSchedule) || isLateTime(movieId, movieSchedule)
                || isWithInOneHour(movieId, movieSchedule, customer)) {
            return selectMovieTime(movieId, customer);
        }

        return movieSchedule;
    }

    private Reservation getReservationMovie(Customer customer, List<Movie> movies) {
        int movieId = selectMovieId(movies);
        Movie movie = getMovie(movies, movieId);

        int movieSchedule = selectMovieTime(movieId, customer);

        int personNumber = selectPeopleNumber(movieId, movieSchedule);
        PlaySchedule playSchedule = selectMovieSchedule(movieId, movieSchedule);

        Reservation reservation = new Reservation(movie, personNumber, playSchedule);

        return reservation;
    }

    private PlaySchedule selectMovieSchedule(int movieId, int movieSchedule) {
        PlaySchedule schedule = MovieRepository.selectSchedule(movieId, movieSchedule);
        return schedule;
    }

    private Movie getMovie(List<Movie> movies, int movieId) {
        Movie selectMovie = null;

        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                selectMovie = new Movie(movieId, movie.getName(), movie.getPrice());
            }
        }

        return selectMovie;
    }

    private int selectPeopleNumber(int movieId, int movieSchedule) {
        int peopleNumber = InputView.inputPeopleNumber();

        if (checkCapacity(peopleNumber, movieId, movieSchedule)) {
            return selectPeopleNumber(movieId, movieSchedule);
        }

        return peopleNumber;
    }

    private List<Integer> makeMoviesIdList(List<Movie> movies) {
        List<Integer> movieIdList = new ArrayList<>();

        for (Movie movie : movies) {
            movieIdList.add(movie.getId());
        }

        return movieIdList;
    }

    private boolean notInSchedule(List<Movie> movies, int movieId) {
        List<Integer> movieIdList = makeMoviesIdList(movies);

        if (!movieIdList.contains(movieId)) {
            System.err.println(NOT_IN_LIST_ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private int selectMovieId(List<Movie> movies) {
        int movieId = InputView.inputMovieId();

        if (notInSchedule(movies, movieId)) {
            return selectMovieId(movies);
        }

        return movieId;
    }

}

