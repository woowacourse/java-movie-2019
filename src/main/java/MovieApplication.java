/*
 * MovieApplication Class
 *
 * @version 1.1
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

        while (true) {
            printBoxOfficeMovie();
            movieId = selectMovieByID();
            printSelectedMovieInfo(movieId);
        }
        // TODO 구현 진행
    }

    public static void printBoxOfficeMovie() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    public static int selectMovieByID() {
        return InputView.inputMovieId();
    }

    public static void printSelectedMovieInfo(int movieId) {
        Movie selectedMovie =
                MovieRepository.getMovieByID(movieId);
        OutputView.printSelectedMovieInfo(selectedMovie);
    }
}
