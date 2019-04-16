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

        String whatMovie = servant.askUserWhatMovie();
        Movie selectedMovie = MovieRepository.findAndReturnMovie(movies, whatMovie);
        System.out.println(selectedMovie);
        String whatTime = servant.askUserWhatTime(selectedMovie);
        String howManyPeople = servant.askHowManyPeople(whatTime, selectedMovie);

    }
}
