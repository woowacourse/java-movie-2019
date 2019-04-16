import domain.Movie;
import domain.MovieRepository;
import domain.PartialApplication;
import domain.PlaySchedule;
import java.util.ArrayList;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {

  public static void main(String[] args) {
    ArrayList<PartialApplication> partialApplications = new ArrayList<PartialApplication>();
    boolean TO_CONTINUE = true;
    while (TO_CONTINUE) {
      PartialApplication pa = new PartialApplication();
      pa.appOfOne();
      partialApplications.add(pa);
      boolean b =
          (pa.checkIfTooMuchPeople()) ? pa.updateMovieForTooMuch() : pa.updateMovieForLess();
      TO_CONTINUE = pa.toContinue();
    }
    showTotal(partialApplications);
    // TODO 구현 진행
  }
  public static void showTotal(ArrayList<PartialApplication> partialApplications){
    System.out.println("예약 내역");
    for(PartialApplication pa : partialApplications){
      OutputView.printReservation(MovieRepository.getMovie(pa.MOVIE_ID), pa.PLAY_SCHEDULE, pa.PEOPLE_WATCHING_MOVIE);
    }
  }
}
