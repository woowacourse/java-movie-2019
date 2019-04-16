/*
 *  @(#)OutputView.java       1.00    2019/04/16
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 *  conatuseus@gmail.com
 */

package view;

import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import domain.User;

import java.util.List;

public class OutputView {

    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printMovieById(int movieId) {
        System.out.println(MovieRepository.getMovieById(movieId));
    }

    public static void printUserReservationList(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
    }

    public static void printPayment(User user) {
        System.out.println(user.toString());
    }
}
