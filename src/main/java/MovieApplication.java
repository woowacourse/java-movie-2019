import domain.BookedMovie;
import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import domain.BookedMovie;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {

        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        List<BookedMovie> bookedMovies = new ArrayList<>();
        int movieId = InputView.inputMovieId();
        // 중복 체크
        //Movie selectedMovie = MovieRepository.getMovieById(movieId);
        Movie selectedMovie = null;
        for (Movie m : movies) {
            if (m.hasSameId(movieId)) {
                selectedMovie = m;
            }
        }
        BookedMovie bookedMovie;

        //if (selectedMovie != null) {
        bookedMovie = new BookedMovie(selectedMovie);
        bookedMovies.add(bookedMovie);
        System.out.println(selectedMovie);
        //}

        int scheduleId = InputView.inputScheduleId();
        // 유효성 체크
        PlaySchedule selectedSchedule = selectedMovie.getScheduleById(scheduleId);
        if (selectedSchedule != null) {
            bookedMovie.updateSchedule(selectedSchedule);
        }

        int personCount = InputView.inputPersonCount();
        // 유효성 체크
        if (selectedSchedule.reserveTickets(personCount)) {
            bookedMovie.updateReservedPersonCount(personCount);
        }

        int additionalReservation = InputView.inputAdditionalReservation();

        if (additionalReservation == 1) {
            OutputView.printBookedMovies(bookedMovies);
        } else if (additionalReservation == 2) {
            // 중복 예약
        }

    }
}
