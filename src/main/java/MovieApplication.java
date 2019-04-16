import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        Movie movie = getMovie(movies);
        OutputView.printMovie(movie);

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
