package domain;

import java.util.List;

public class MovieBookingMachine {

    private BookedMovies bookedMovies = new BookedMovies();

    public void book(MovieSchedule movieSchedule, int personNumber) {
        bookedMovies.bookMovie(movieSchedule, personNumber);
    }

    public BookedMovies getBookedMovies() {
        return bookedMovies;
    }

    public List<Movie> getMovies() {
        return MovieRepository.getMovies();
    }
}
