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
    private static final int MIN_RESERVED_PERSON_COUNT = 1;

    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<BookedMovie> bookedMovies = new ArrayList<>();
        boolean isBooking = true;
        while (isBooking) {
            OutputView.printMovies(movies);
            int movieId = getValidMovieId(bookedMovies);
            BookedMovie bookedMovie = bookOneMovie(movieId);
            bookedMovies.add(bookedMovie);
            isBooking = InputView.inputAdditionalReservation() == 2;
        }
        OutputView.printBookedMovies(bookedMovies);
        //결제
    }

    private static int getValidMovieId(List<BookedMovie> bookedMovies) {
        int movieId = InputView.inputMovieId();
        if (MovieRepository.isValidMovieId(movieId)
                && !checkMovieBooked(movieId, bookedMovies)) {
            return movieId;
        }
        return getValidMovieId(bookedMovies);
    }

    private static boolean checkMovieBooked(int movieId, List<BookedMovie> bookedMovies) {
        for (BookedMovie b : bookedMovies) {
            if (b.checkMovieId(movieId)) {
                return true;
            }
        }
        return false;
    }

    private static BookedMovie bookOneMovie(int movieId) {
        Movie selectedMovie = MovieRepository.getMovieById(movieId);
        assert selectedMovie != null;

        BookedMovie bookedMovie = new BookedMovie(selectedMovie);
        OutputView.printSelectedMovie(selectedMovie);

        PlaySchedule selectedSchedule = decideSchedule(selectedMovie, bookedMovie);
        decidePersonCount(bookedMovie, selectedSchedule);
        return bookedMovie;
    }

    private static PlaySchedule decideSchedule(Movie selectedMovie, BookedMovie bookedMovie) {
        int scheduleId = InputView.inputScheduleId();
        PlaySchedule selectedSchedule = selectedMovie.getScheduleById(scheduleId);
        while (selectedSchedule == null) {
            scheduleId = InputView.inputScheduleId();
            selectedSchedule = selectedMovie.getScheduleById(scheduleId);
        }
        bookedMovie.updateSchedule(selectedSchedule);
        return selectedSchedule;
    }

    private static void decidePersonCount(BookedMovie bookedMovie, PlaySchedule selectedSchedule) {
        int personCount = InputView.inputPersonCount();
        while (!selectedSchedule.reserveTickets(personCount, MIN_RESERVED_PERSON_COUNT)) {
            personCount = InputView.inputPersonCount();
        }
        bookedMovie.updateReservedPersonCount(personCount);
    }
}
