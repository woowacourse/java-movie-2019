package domain;

import utils.DateTimeUtils;

public class Reservation {

    private final Movie movie;
    private final int scheduleNumber;
    private final int buyCount;

    public Reservation(Movie movie, int scheduleNumber, int buyCount) {
        this.movie = movie;
        this.scheduleNumber = scheduleNumber;
        this.buyCount = buyCount;
        this.setMovieRepository();
    }

    private void setMovieRepository() {
        MovieRepository.buyMovieTickets(movie, scheduleNumber, buyCount);
    }

    public Movie getMovie() {
        return movie;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void isMatchInOneHour(int timeIndex) {
        if (movie.isOneHourWithRangeMovie(timeIndex)) {
            throw new IllegalArgumentException("1시간 이내의 영화는 예매 불가능합니다");
        }
    }
}
