package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinTask;

import static utils.DateTimeUtils.createDateTime;

public class MovieRepository {
    private static final int ONE = 1;
    private static List<Movie> movies = new ArrayList<>();

    static {
        Movie movie1 = new Movie(1, "생일", 8_000);
        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 12:00"), 6));
        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 14:40"), 6));
        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 17:00"), 6));
        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 19:40"), 3));
        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 22:00"), 3));
        movies.add(movie1);

        Movie movie2 = new Movie(5, "돈", 10_000);
        movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 08:00"), 3));
        movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 10:30"), 5));
        movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 13:00"), 5));
        movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 15:30"), 5));
        movies.add(movie2);

        Movie movie3 = new Movie(7, "파이브피트", 9_000);
        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 13:00"), 4));
        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 15:40"), 4));
        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 18:00"), 4));
        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 20:40"), 3));
        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 23:15"), 3));
        movies.add(movie3);

        Movie movie4 = new Movie(8, "덤보", 9_000);
        movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 11:30"), 2));
        movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 16:00"), 3));
        movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 21:30"), 2));
        movies.add(movie4);
    }

    public static List<Movie> getMovies() {
        return movies;
    }

    public static Movie getWantMovie(int movieId) {
        if (isContains(movieId)) {
            return movies.get(movieId);
        }
        throw new IllegalArgumentException("상영 목록에 없는 영화를 선택하셨습니다");
    }

    private static boolean isContains(int movieId) {
        return movies.stream()
                .anyMatch(movie -> movie.isRightMovie(movieId));
    }

    public static List<PlaySchedule> getPlaySchedule(Movie inputMovie) {
        HashSet<Movie> hashSet = new HashSet(movies);
        if (hashSet.contains(inputMovie)) {
            return getWantMovie(inputMovie.getId()).getPlaySchedules();
        }
        throw new IllegalArgumentException("스케줄이 없습니다");
    }

    public static void buyMovieTickets(Movie movie, int playScheduleIndex, int buyCount) {
        List<PlaySchedule> playScheduleList = getPlaySchedule(movie);
        playScheduleList.get(playScheduleIndex - 1).buyTicket(buyCount);
    }

    public static boolean isAllMoviePossible() {
        return movies.stream()
                    .anyMatch(movie -> movie.isMoviePossible());
    }
}
