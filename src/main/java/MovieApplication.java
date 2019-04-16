/*
 * MovieApplication Class
 *
 * @version 1
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
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        while(true) {
            int movieId = InputView.inputMovieId();
            System.out.println(MovieRepository.isContainMovieId(movieId));
        }
        // TODO 구현 진행
    }
}
