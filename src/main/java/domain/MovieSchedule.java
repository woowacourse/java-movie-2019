package domain;

import java.time.LocalDateTime;

public class MovieSchedule {

    private final int movieId;
    private final String movieName;
    private final int moviePrice;
    private final LocalDateTime movieStartDateTime;
    private final int movieCapacity;
    private final int movieBookedNumber;

    public MovieSchedule(int movieId, int movieScheduleOrder, int movieBookedNumber) {
        Movie movie = MovieRepository.getMovie(movieId);
        this.movieId = movie.getId();
        this.movieName = movie.getName();
        this.moviePrice = movie.getPrice();

        PlaySchedule playSchedule = movie.getPlaySchedule(movieScheduleOrder);
        this.movieStartDateTime = playSchedule.getStartDateTime();
        this.movieCapacity = playSchedule.getCapacity();

        this.movieBookedNumber = movieBookedNumber;
    }
}
