import domain.*;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int selectMovieId = InputView.inputMovieId();
        Movie selectMovie = MovieRepository.getSelectMovie(selectMovieId);
        OutputView.printSelectMovie(selectMovieId);

        BoxOffice boxOffice = new BoxOffice(selectMovie);

        int selectMovieSchedule = InputView.inputMovieSchedule();
        int peopleCount = InputView.inputPeopleCount();
        PlaySchedule selectSchedule = boxOffice.selectSchedule(selectMovieSchedule, peopleCount, LocalDateTime.now());

        OutputView.printBookingHistory(selectMovie, selectSchedule, peopleCount);
        int inputPoint = InputView.inputGetPoint();
        int methodOfPayment = InputView.inputSelectCashOrCard();


        // TODO 구현 진행
    }
}
