package domain;

import java.util.List;
import view.InputView;
import view.OutputView;

public class PartialApplication {

  Movie movieOfId;
  int movieScheduleNum;
  private PlaySchedule playSchedule;
  int peopleWatchingMovie;

  public void appOfOne() {
    OutputView.printMovies(MovieRepository.getMovies());
    int movieId = InputView.inputMovieId();
    movieOfId = MovieRepository.getMovie(movieId);
    OutputView.printMovie(movieOfId);
    movieScheduleNum = InputView.inputMovieScheduleNum();
    playSchedule = MovieRepository.playScheduleOfMovieOfNum(movieOfId, movieScheduleNum);
  }

  public boolean checkIfTooMuchPeople() {
    peopleWatchingMovie = InputView.inputPeopleWatchingMovie();
    if (playSchedule.getCapacity() < peopleWatchingMovie) {
      return true;
    }
    return false;
  }

  public boolean updateMovieSchedule() {
    if (checkIfTooMuchPeople()) {
      peopleWatchingMovie = peopleWatchingMovie - movieOfId.getPlaySchedule().get(movieScheduleNum-1).getCapacity();
      movieOfId.getPlaySchedule().remove(movieScheduleNum - 1);
      movieOfId.setPlaySchedules(movieOfId.getPlaySchedule());
      return true;
    }
    if(!checkIfTooMuchPeople()){
      movieOfId.getPlaySchedule().get(movieScheduleNum - 1).setCapacity(movieOfId.getPlaySchedule().get(movieScheduleNum - 1).getCapacity() - peopleWatchingMovie);
    }
    return false;
  }
}
