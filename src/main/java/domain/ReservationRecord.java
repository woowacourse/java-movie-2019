package domain;

import java.time.LocalDateTime;
import utils.DateTimeUtils;

public class ReservationRecord {

    private Movie movie;
    public int movieEntryNumber;
    private int movieCapacity;
    private LocalDateTime movieStartDateTime;

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

    @Override
    public String toString() {
        String formattedDate = DateTimeUtils.format(movieStartDateTime);
        return String.format("%s\n 시작시간 %s\n예약인원: %d", movie, formattedDate, movieCapacity);
    }
}

