/*
 * OutputView Class
 *
 * @version 1
 *
 * @date 2019-04-16
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package view;

import domain.Movie;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
