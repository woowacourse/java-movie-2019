import domain.Movie;
import domain.MovieRepository;
import domain.MovieReservation;
import domain.PlaySchedule;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    private static List<MovieReservation> movieReservations = new ArrayList<>();

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        do {
            movieReservations.add(getMovieReservation(movies));
        } while (moreReservation());

        OutputView.printReservations(movieReservations);
        payment();
    }

    private static void payment() {
        System.out.println("##결제를 진행합니다.");
        int finalPrice = getPrice() - InputView.inputPoint();
        double discountRate = 0.05;
        if (InputView.inputPaymentMethod() == 2) {
            discountRate = 0.02;
        }
        finalPrice = (int)(finalPrice * (1 - discountRate));
        OutputView.printPaymentResult(finalPrice);
    }

    private static int getPrice() {
        int price = 0;
        for (MovieReservation movieReservation : movieReservations) {
            price +=movieReservation.getPrice();
        }
        return price;
    }

    private static MovieReservation getMovieReservation(List<Movie> movies) {
        Movie movie = getMovie(movies);
        OutputView.printMovie(movie);
        PlaySchedule playSchedule = getPlaySchedule(movie);
        int watcher = getWatcher(movie, playSchedule);
        return new MovieReservation(movie, playSchedule, watcher);
    }

    private static boolean moreReservation() {
        int number = InputView.inputMoreReservation();
        if (number == 1) {
            return false;
        }
        return true;
    }

    private static int getWatcher(Movie movie, PlaySchedule playSchedule) {
        try {
            int watcher = InputView.inputMovieWatcher();
            movie.validateWatcher(watcher, playSchedule);
            return watcher;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWatcher(movie, playSchedule);
        }
    }

    private static PlaySchedule getPlaySchedule(Movie movie) {
        try {
            PlaySchedule playSchedule = movie.getPlaySchedule(InputView.inputMovieSchedule());
            validateSchedule(playSchedule);
            return playSchedule;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlaySchedule(movie);
        }
    }

    private static void validateSchedule(PlaySchedule playSchedule) throws IllegalArgumentException {
        for (MovieReservation movieReservation : movieReservations) {
            movieReservation.validateSchedule(playSchedule);
        }
    }

    private static Movie getMovie(List<Movie> movies) {
        try {
            return movieFromMovies(InputView.inputMovieId(), movies);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMovie(movies);
        }
    }

    public static Movie movieFromMovies(int movieId, List<Movie> movies) throws IllegalArgumentException{
        Movie movie = null;
        for (Movie m : movies) {
            movie = m.isMyMovieId(movieId) ? m : movie;
        }
        if (movie == null) {
            throw new IllegalArgumentException("영화 목록에 존재하지 않는 ID 입니다.");
        }
        return movie;
    }
}
