package domain;

import java.time.LocalDateTime;

class ReservationRecord {

    private int movieId;
    private int movieCapacity;
    private int movieEntryNumber;
    private LocalDateTime movieStartDateTime;

    ReservationRecord(int movieId, int movieCapacity, int movieEntryNumber,
                      LocalDateTime movieStartDateTime) {
        this.movieId = movieId;
        this.movieCapacity = movieCapacity;
        this.movieEntryNumber = movieEntryNumber;
        this.movieStartDateTime = movieStartDateTime;
    }

    LocalDateTime getMovieStartDateTime() {
        return this.movieStartDateTime;
    }
}

