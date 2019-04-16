import domain.Movie;
import domain.MovieRepository;

import domain.ReservedMovie;
import input.Continue;
import input.MemberNumberInput;
import input.ScheduleInput;
import view.InputView;
import view.OutputView;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<ReservedMovie> reservedMovies = new ArrayList<ReservedMovie>();
        start(reservedMovies);

    }

    private static void start(List<ReservedMovie> reservedMovies) {
        choose(reservedMovies);
        Continue choice = InputView.askContinuePurchaseOrNot();
        OutputView.printReservedMovies(reservedMovies);
        if (choice == Continue.YES) {
            start(reservedMovies);
        }
    }

    private static void choose(List<ReservedMovie> reservedMovies) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Movie movie = InputView.inputMovie(movies);
        OutputView.printMovies(movie);

        int scheduleId = InputView.getScheduleId(movie);
        int memberNumber = InputView.getMemberNumber(movie, scheduleId);
        reservedMovies.add(new ReservedMovie(movie,scheduleId,memberNumber));
    }




}
