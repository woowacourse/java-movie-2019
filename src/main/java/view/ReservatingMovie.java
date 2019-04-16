package view;

import domain.Movie;
import domain.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservatingMovie {
    private List<Integer> reservateMoviesId;
    private List<Movie> movies;
    private List<Movie> reserVatedMovies;

    ReservatingMovie(List<Integer> reservateMovies) {

        this.movies = MovieRepository.getMovies();
        this.reserVatedMovies = new ArrayList<>();

        if (MovieRepository.isValidMoviesId(reservateMovies)) {
            this.reservateMoviesId = reservateMovies;
            return;
        }

        throw new IllegalArgumentException("올바른 예매 영화번호를 입력해 주세요.");
    }

    public List<Movie> GenerateReservatedMovie() {
        List<Movie> movies = MovieRepository.getMovies();
        movies.stream()
                .filter(m -> reservateMoviesId.contains(m.getId()))
                .forEach(m -> this.reserVatedMovies.add(m));

        return this.reserVatedMovies;
    }

}
