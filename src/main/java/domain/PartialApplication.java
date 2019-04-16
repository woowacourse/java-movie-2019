package domain;

import java.util.List;
import view.InputView;
import view.OutputView;

public class PartialApplication {

  public void appOfOne() {
    OutputView.printMovies(MovieRepository.getMovies());
    int movieId = InputView.inputMovieId();
    Movie movieOfId = MovieRepository.getMovie(movieId);
    OutputView.printMovie(movieOfId);
    int movieScheduleNum = InputView.inputMovieScheduleNum();
    PlaySchedule playSchedule = MovieRepository.playScheduleOfMovieOfNum(movieOfId, movieScheduleNum);
    int peopleWatchingMovie = InputView.inputPeopleWatchingMovie();
  }
}
