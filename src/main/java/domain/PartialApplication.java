package domain;

import java.util.List;
import view.InputView;
import view.OutputView;

public class PartialApplication {

  private PlaySchedule playSchedule;

  public void appOfOne() {
    OutputView.printMovies(MovieRepository.getMovies());
    int movieId = InputView.inputMovieId();
    Movie movieOfId = MovieRepository.getMovie(movieId);
    OutputView.printMovie(movieOfId);
    int movieScheduleNum = InputView.inputMovieScheduleNum();
    playSchedule = MovieRepository.playScheduleOfMovieOfNum(movieOfId, movieScheduleNum);
  }

  public boolean checkIfTooMuchPeople() {
    int peopleWatchingMovie = InputView.inputPeopleWatchingMovie();
    if(playSchedule.getCapacity()<peopleWatchingMovie) return true;
    return false;
  }
}
