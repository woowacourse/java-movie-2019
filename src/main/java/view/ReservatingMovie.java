package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ReservatingMovie {
    private List<Integer> reservateMovieId;
    private List<Movie> movies;

    ReservatingMovie(List<Integer> reservateMovies) {

        if (MovieRepository.isValidMoviesId(reservateMovies)) {
            this.reservateMovieId = reservateMovies;
            return;
        }

        throw new IllegalArgumentException("올바른 예매 영화번호를 입력해 주세요.");
    }

}
