package view;

import domain.Book;
import domain.Movie;

import java.util.List;

public class OutputView {

  public static void printMovies(List<Movie> movies) {
    for (Movie movie : movies) {
      System.out.println(movie);
    }
  }

  private static void FindMovieId(Movie movie, int movieId){
    if(movie.IsCorrectNumberOfMovie(movieId)){
      System.out.println(movie);
    }
  }

  public static void printOneMovie(List<Movie> movies, int movieId) {
    for(Movie movie : movies){
      FindMovieId(movie, movieId);
    }
  }

  public static void PrintReservation(List<Book> bookList){
    for (int i = 0; i < bookList.size(); i++) {
      System.out.println(bookList.get(i).ViewBooking());
    }
  }
}
