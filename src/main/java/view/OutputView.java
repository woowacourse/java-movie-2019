package view;

import domain.Movie;
import utils.DateTimeUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static utils.DateTimeUtils.format;
import static utils.DateTimeUtils.isOneHourWithinRange;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    /*
     * 예약할 영화를 출력하고 담음
     */
    public static Movie getAndprintChosenMovie(List<Movie> movies, int movieId) {
        boolean answer = false;
        Movie movie = null;
        for (int i = 0; i < movies.size() && answer == false; i++) {
            movie = movies.get(i);
            boolean recognize = false;
            recognize = (movie.getId() == movieId) ? true : false;
            answer = answer || recognize;
        }
        System.out.println(movie);
        return movie;
    }

    /*
     * 실패 조건에 부합하면 오류를 발생
     */
    public static void makeFail(Movie movie, List<LocalDateTime> times, LocalDateTime localDateTime) {
        if (judgeOneHour(times, localDateTime) && judgeStartTime(movie, times.get(times.size() - 1)) == false) {
            throw new IllegalArgumentException();
        }

    }


}
