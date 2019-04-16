package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;
import static domain.Movie.NEW_LINE;

public class ReservationMovie {
    private static final String HYPHEN = " - ";
    private static final String START_TIME = "시작시간: ";
    private static final String NUMBER_OF_RESERVATION_PEOPLE = "예약인원: ";
    private static final String NUMBER_OF_PERSON = "명";
    private static final String COMMA = ", ";
    private static final String WON = "원";

    private int movieId;
    private int moviePrice;
    private String movieName;
    private LocalDateTime movieTime;
    private int reservedNumberOfPeople;

    public ReservationMovie(Movie movie, int movieTime, int reservedNumberOfPeople) {
        this.movieId = movie.getId();
        this.moviePrice = movie.getPrice();
        this.movieName = movie.getName();
        this.movieTime = movie.getReserveMovieTime(movieTime);
        this.reservedNumberOfPeople = reservedNumberOfPeople;
    }

    @Override
    public String toString() {
        return movieId + HYPHEN + movieName + COMMA + moviePrice + WON + NEW_LINE
                + START_TIME + format(movieTime) + NEW_LINE
                + NUMBER_OF_RESERVATION_PEOPLE + reservedNumberOfPeople + NUMBER_OF_PERSON;
    }
}