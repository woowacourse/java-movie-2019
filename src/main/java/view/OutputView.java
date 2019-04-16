package view;

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

  private static void FindMovieSchedule(Movie movie, int movieId, int movieSchedule){
    if(movie.IsCorrectNumberOfMovie(movieId)) {
      String schedule = movie.getOneSchedule(movieSchedule);
      System.out.println(schedule);
    }
  }

  public static void printOneMovie(List<Movie> movies, int movieId) {
    for(Movie movie : movies){
      FindMovieId(movie, movieId);
    }
  }

}
