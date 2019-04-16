package domain;

import java.time.LocalDateTime;

public class ReservationRecord {

    public Movie movie;
    public int movieEntryNumber;
    public int movieCapacity;
    public LocalDateTime movieStartDateTime;

    ReservationRecord(int movieId, int movieCapacity, int movieEntryNumber) {
        Movie movie = MovieRepository.getMovies().get(movieId);
        this.movie = movie;
        this.movieCapacity = movieCapacity;
        this.movieStartDateTime = movie.getPlaySchedules().get(movieEntryNumber - 1)
            .getStartDateTime();
    }

    LocalDateTime getMovieStartDateTime() {
        return this.movieStartDateTime;
    }
}

