import domain.Movie;
import domain.MovieRepository;
import domain.ReservationBox;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        //int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        ReservationBox servant = new ReservationBox();
        doGame(movies, servant);


    }

    public static void doGame(List<Movie> movies, ReservationBox servant) {
        String whatMovie = servant.askUserWhatMovie();
        Movie selectedMovie = MovieRepository.findAndReturnMovie(movies, whatMovie);
        System.out.println(selectedMovie);
        String whatTime = servant.askUserWhatTime(selectedMovie);
        String howManyPeople = servant.askHowManyPeople(whatTime, selectedMovie);
        servant.saveInformation(selectedMovie, whatTime, howManyPeople);
        int userInputContinue = servant.askUserContinue();
        if (userInputContinue == 2) {
            doGame(movies, servant);
        }
        int total = servant.calculatePayment();
        servant.printPayment(toal);
    }
}
