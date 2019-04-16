package service;

import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieReservation {
    public void run() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
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
            System.err.println("상영목록에 없는 영화입니다.");
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

