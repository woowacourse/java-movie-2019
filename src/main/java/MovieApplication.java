import domain.Movie;
import domain.MovieRepository;
import domain.ReservationCategory;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieApplication {

    static List<ReservationCategory> reservationCategory = new ArrayList<>();

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId();

        // TODO 구현 진행
        Movie choiceMovie =  OutputView.printChoiceMovies(movies, movieId);
        int choiceTime = InputView.inputChoiceTime();
        int reservedPerson = InputView.inputReservedPerson();

        reservedTimeSchedule(choiceMovie, choiceTime, reservedPerson);

        int isPayment = InputView.inputIsPayment();
        OutputView.printReservedCategory(reservationCategory, isPayment);
        OutputView.progressPayment(reservationCategory);

    }

    private static void reservedTimeSchedule(Movie choiceMovie, int choiceTime, int reservedPerson){
        reservationCategory.add(new ReservationCategory(choiceMovie, choiceMovie.getPlaySchedules().get(choiceTime-1).getStartDateTime(), reservedPerson));
    }


}
