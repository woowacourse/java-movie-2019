package domain;

import java.util.List;

public class Validator {
    private static List<Movie> movies = MovieRepository.getMovies();

    public static void checkMovieId(int movieId) {
        for (Movie movie : movies) {
            if (movie.isEqualMovie(movieId)) return; // 수정 필요, indent 2
        }
        throw new IllegalArgumentException();
    }

    public static void checkMovieTime(int movieId, int movieTime) {
        Movie movie = MovieRepository.getMovie(movieId);
        checkRightMovieTime(movie, movieTime);
        checkAvailableSeats(movie, movieTime);
    }

    public static void checkRightMovieTime(Movie movie, int movieTime) {
        if (movieTime >= 0 && movie.isValidMovieTime(movieTime)) {
            return;
        }
        throw new IllegalArgumentException("올바른 시간표 번호를 입력해 주세요.");
    }

    public static void checkAvailableSeats(Movie movie, int movieTime) {
        if (movie.isThisTimeAvailable(movieTime)) {
            return;
        }
        throw new IllegalArgumentException("예약가능인원을 확인해 주세요.");
    }

    public static void checkNumOfGuest(int movieId, int movieTime, int numOfGuest) {
        Movie movie = MovieRepository.getMovie(movieId);
        if (movie.isThisNumberAvailable(movieTime, numOfGuest) && numOfGuest > 0) {
            return;
        }
        throw new IllegalArgumentException("예약가능인원을 확인해 주세요.");
    }

    public static void checkQuitOrDoAgain(int quitOrDoAgain) {
        if (quitOrDoAgain == 1 || quitOrDoAgain == 2) {
            return;
        }
        throw new IllegalArgumentException("1이나 2만 입력해 주세요.");
    }
}