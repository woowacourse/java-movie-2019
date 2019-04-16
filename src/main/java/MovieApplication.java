/*
 * MovieApplication Class
 *
 * @version 1.3
 *
 * @date 2019-04-16
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */

import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        int movieId;

        printBoxOfficeMovie();
        movieReserveProcess();
        // TODO 구현 진행
    }

    public static void printBoxOfficeMovie() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    public static void movieReserveProcess() {
        try {
            printSelectedMovieInfo(selectMovieByID());
        } catch (IllegalArgumentException e) {
            OutputView.printRestartReservation(e);
            movieReserveProcess();
        }
    }

    public static int selectMovieByID() {
        int selectedMovieId = InputView.inputMovieId();

        if (!MovieRepository.isContainMovieId(selectedMovieId))
            throw new IllegalArgumentException("해당하는 영화의 ID 가 없습니다.");

        return selectedMovieId;
    }

    public static void printSelectedMovieInfo(int movieId) {
        Movie selectedMovie =
                MovieRepository.getMovieByID(movieId);
        OutputView.printSelectedMovieInfo(selectedMovie);
    }
}
