import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    private static List<Movie> movies = MovieRepository.getMovies();
    private static UserInfo userInfo = new UserInfo();

    public static void main(String[] args) {
        MovieBookingInfo myMovie = reserveMovie();
        

    }

    private static MovieBookingInfo reserveMovie() {
        MovieBookingInfo movieBookingInfo = null;
        do {
            OutputView.printMovies(movies);
            Movie movie = selectMovie();
            OutputView.printPlaySchedule(movie);
            PlaySchedule playSchedule = selectSchedult(movie);
            int nPeople = selectPoepleNumber(playSchedule);
            movieBookingInfo = new MovieBookingInfo(movie, playSchedule, nPeople);

        } while (InputView.selectPayment());

        return movieBookingInfo;
    }

    private static Movie selectMovie() {
        OutputView.printMovies(movies);
        int movieId = InputView.inputMovieId();
        return MovieRepository.findById(movieId);
    }

    private static PlaySchedule selectSchedult(Movie movie) {
        int scheduleIndex = InputView.inputPlaySchedule() - 1;
        return movie.getPlaySchedule(scheduleIndex);
    }

    private static int selectPoepleNumber(PlaySchedule playSchedule) {
        int nPeople = InputView.inputPeopleNumber();
        // TODO: 인원 체크
        return nPeople;
    }
}
