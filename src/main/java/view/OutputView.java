/*
 * OutputView Class
 *
 * @version 1.3
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

    public static void printRestartReservation(Exception e) {
        System.out.println(e.getMessage());
        System.out.println("예매 진행을 다시 시작합니다.");
    }

    public static void printSelectedMovieInfo(Movie movie) {
        System.out.println(movie);
    }
}
