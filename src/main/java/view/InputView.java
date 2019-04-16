package view;

import domain.Movie;
import domain.MovieRepository;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static boolean IsCorrectMovieId(int movieId) {
    List<Movie> movies = MovieRepository.getMovies();
    for (Movie movie : movies) {
      if (movie.IsCorrectNumberOfMovie(movieId)) {
        return true;
      }
    }
    return false;
  }

  public static int inputMovieId() {
    int movieId;
    do {
      System.out.println("## 예약할 영화를 선택하세요.");
      movieId = scanner.nextInt();
    }while(!IsCorrectMovieId(movieId));
    return movieId;
  }

}