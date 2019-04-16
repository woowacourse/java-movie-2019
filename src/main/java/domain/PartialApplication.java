package domain;

import java.util.List;
import view.InputView;
import view.OutputView;

public class PartialApplication {

  int MOVIE_ID;
  Movie MOVIE_OF_ID;
  int MOVIE_SCHEDULE_NUM;
  private PlaySchedule PLAY_SCHEDULE;
  public int PEOPLE_WATCHING_MOVIE;

  public void appOfOne() {
    OutputView.printMovies(MovieRepository.getMovies());
    MOVIE_ID = InputView.inputMovieId();
    MOVIE_OF_ID = MovieRepository.getMovie(MOVIE_ID);
    OutputView.printMovie(MOVIE_OF_ID);
    MOVIE_SCHEDULE_NUM = InputView.inputMovieScheduleNum();
    PLAY_SCHEDULE = MovieRepository.playScheduleOfMovieOfNum(MOVIE_OF_ID, MOVIE_SCHEDULE_NUM);
  }

  public boolean checkIfTooMuchPeople() {
    PEOPLE_WATCHING_MOVIE = InputView.inputPeopleWatchingMovie();
    if (PLAY_SCHEDULE.getCapacity() < PEOPLE_WATCHING_MOVIE) {
      return true;
    }
    return false;
  }

  public boolean updateMovieForTooMuch() {
    PEOPLE_WATCHING_MOVIE -= MovieRepository.getMovie(MOVIE_ID).getPlaySchedule()
        .get(MOVIE_SCHEDULE_NUM - 1).getCapacity();
    MovieRepository.getMovie(MOVIE_ID).getPlaySchedule().get(MOVIE_SCHEDULE_NUM - 1).setCapacity(0);
    return true;
  }

  public boolean updateMovieForLess() {
    MovieRepository.getMovie(MOVIE_ID).getPlaySchedule().get(MOVIE_SCHEDULE_NUM - 1).setCapacity(
        MovieRepository.getMovie(MOVIE_ID).getPlaySchedule().get(MOVIE_SCHEDULE_NUM - 1)
            .getCapacity() - PEOPLE_WATCHING_MOVIE);
    return false;
  }

  public boolean toContinue() {
    if (InputView.inputIfContinue() == 1) {
      return false;
    }
    return true;
  }
}
