package view;

import domain.Movie;

import domain.PlaySchedule;
import java.util.List;

public class OutputView {

  public static void printMovies(List<Movie> movies) {
    for (Movie movie : movies) {
      System.out.println(movie);
    }
  }

  public static void printMovie(Movie movie) {
    System.out.println(movie);
  }

  public static void printReservation(Movie movie, PlaySchedule playSchedule, int reservationNum) {
    movie.printNameAndCost();
    System.out.print("시작 시간 : " + playSchedule);
    System.out.println("예약 인원 : " + reservationNum + "명");
  }
}
