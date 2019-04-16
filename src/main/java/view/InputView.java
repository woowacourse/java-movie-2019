package view;

import domain.Movie;
import domain.MovieRepository;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final int continueBook = 2;
  private static final int finishBook = 1;
  private static final Scanner scanner = new Scanner(System.in);

  public static boolean IsCorrectMovieId(int movieId) {
    return MovieRepository.IsIncludeMovie(movieId);
  }

  private static boolean IsCorrectMovieSchedule(int movieId, int movieSchedule) {
    Movie movie = MovieRepository.getIdOfMovie(movieId);
    return movie.IsBookableSequence(movieSchedule);
  }

  public static int InputValidNumber() {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("유효하지 않은 값입니다");
      System.exit(-1);
    }
    return -1;
  }

  public static int inputMovieId() {
    int movieId;
    do {
      System.out.println("## 예약할 영화를 선택하세요.");
      movieId = InputValidNumber();
    } while (!IsCorrectMovieId(movieId));
    return movieId;
  }

  public static int InputMovieSchedule(int movieId) {
    int movieSchedule;
    do {
      System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
      movieSchedule = InputValidNumber();
    } while (!IsCorrectMovieSchedule(movieId, movieSchedule));
    return movieSchedule;
  }

  public static int InputBookingNumber(int movieId, int movieSequence) {
    Movie movie = MovieRepository.getIdOfMovie(movieId);
    int bookNum;
    do {
      System.out.println("## 예약할 인원을 입력하세요.");
      bookNum = InputValidNumber();
    } while (movie.IsBookableNumber(movieSequence, bookNum));
    return bookNum;
  }

  public static boolean InputContinue() {
    int continueGame;
    do {
      System.out.println("## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
      continueGame = InputValidNumber();
    } while (continueGame != continueBook && continueGame != finishBook);
    if (continueGame == continueBook) {
      return true;
    }
    return false;
  }
}