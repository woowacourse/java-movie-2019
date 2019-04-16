import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;
import receiver.movieNumReceiver;
import receiver.scheduleNumReceiver;
import receiver.numberOfPeopleReceiver;
import receiver.getSelectNumberReciever;
import java.util.List;
import java.util.Scanner;
import utils.DateTimeUtils;
public class MovieApplication {
    public static void main(String[] args) {
        int i = 1;
            Scanner sc = new Scanner(System.in);
            List<Movie> movies = MovieRepository.getMovies();
            OutputView.printMovies(movies);

//        int movieId = InputView.inputMovieId();

            // TODO 구현 진행
            int movienum = movieNumReceiver.getMovieNumFromUser(sc);
            OutputView.printMovie(movies, movienum);
            int scheduleNum = scheduleNumReceiver.getScheduleNumFromUser(sc);
            int peopleNum = numberOfPeopleReceiver.getPeopleNumFromUser(sc);
//            i = getSelectNumberReciever.getSelectNumberReciever(sc);
            OutputView.reservationInformation(movies,movienum,scheduleNum,peopleNum);

    }
}
