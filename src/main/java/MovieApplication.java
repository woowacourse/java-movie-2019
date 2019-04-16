import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        List<Movie> selectMovies = new ArrayList<>();
        List<PlaySchedule> selectSchedules = new ArrayList<>();
        String nowStr = DateTimeUtils.format(LocalDateTime.now());
        LocalDateTime now = DateTimeUtils.createDateTime(nowStr);

        Movie movie;
        PlaySchedule playSchedule;
        int personnel = 0;
        boolean isReservation;
        int sum;
        double amount;

        do {
            movie = selectMovie(movies);
            playSchedule = selectSchedule(movie);
            isReservation = checkStartTime(playSchedule, now);
            if (isReservation) {
                addSelectMovie(selectMovies, movie);
                addSelectSchedules(selectSchedules, playSchedule);
                personnel = selectPersonnel(playSchedule);
            }
        } while (!isReservation || selectReservation());

        sum = sumMoviesPrice(selectMovies, personnel);
        amount = resultAmount(sum , InputView.inputPoint());
        
        result(amount);
    }

    public static void result(double amount) {
        OutputView.printBillingProgress();
        OutputView.printResult((int)amount);
    }

    public static double resultAmount(int sum, int point) {
        int selectNum = InputView.inputSelectPayment();
        double amount = sum - point;

        if (selectNum == 1) {
            amount = amount * 0.95;
        }

        if (selectNum == 2) {
            amount = amount * 0.98;
        }

        return amount;
    }

    public static int sumMoviesPrice(List<Movie> selectMovies, int personnel) {
        int sum = 0;

        for (Movie movie : selectMovies) {
            sum += movie.getPrice();
        }

        return sum * personnel;
    }

    public static boolean selectReservation() {
        int selectNum = InputView.inputSelectStatus();

        if (selectNum == 1) {
            return false;
        }

        if (selectNum == 2) {
            return true;
        }

        System.out.println("올바른 번호를 입력해주세요.");
        return selectReservation();
    }

    public static boolean checkStartTime(PlaySchedule playSchedule, LocalDateTime now) {
        if (!playSchedule.checkStartDateTime(now)) {
            System.out.println("영화가 상영중이거나 종료되었습니다.");
            return false;
        }

        return true;
    }

    public static int selectPersonnel(PlaySchedule playSchedule) {
        int personnel = InputView.inputPersonnel();
        boolean isCapacity = playSchedule.checkCapacity(personnel);

        if (isCapacity) {
            return selectPersonnel(playSchedule);
        }

        return personnel;
    }

    public static PlaySchedule selectSchedule(Movie movie) {
        int movieSchedule = InputView.inputMovieSchedule();

        try {
            PlaySchedule playSchedule = movie.getPlaySchedules().get(movieSchedule - 1);
            return playSchedule;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("범위를 벗어났습니다.");
            return selectSchedule(movie);
        }

    }

    public static Movie selectMovie(List<Movie> movies) {
        int movieId = InputView.inputMovieId();
        Movie movie = OutputView.printMovieSchedule(movies, movieId);

        if (movie == null) {
            System.out.println("선택된 영화는 존재하지 않습니다.");
            return selectMovie(movies);
        }

        return movie;
    }

    public static void addSelectMovie(List<Movie> selectMovies, Movie movie) {
        selectMovies.add(movie);
    }

    public static void addSelectSchedules(List<PlaySchedule> selectSchedule, PlaySchedule playSchedule) {
            selectSchedule.add(playSchedule);
    }

    /* tset */
    public static void printMovie(List<Movie> selectMovies) {
        for (Movie movie : selectMovies) {
            System.out.println(movie);
        }
    }

    public static void printSchedule(List<PlaySchedule> playSchedules) {
        for (PlaySchedule playSchedule : playSchedules) {
            System.out.println(playSchedule);
        }
    }
}
