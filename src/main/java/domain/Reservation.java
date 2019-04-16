package domain;

public class Reservation {

    private final int movieId;

    public Movie getMovie() {
        return movie;
    }

    private final Movie movie;
    private final int scheduleNumber;

    public int getBuyCount() {
        return buyCount;
    }

    private final int buyCount;

    public Reservation(int movieId, int scheduleNumber, int buyCount) {
        this.movieId = movieId;
        movie = MovieRepository.getWantMovie(movieId);
        this.scheduleNumber = scheduleNumber;
        this.buyCount = buyCount;
        setMovieRepository();
    }

    private void setMovieRepository() {
        //movieId를 인자로 Movie를 찾고
        // playSchedule에서 capcity 제거
        MovieRepository.buyMovieTickets(movieId, scheduleNumber, buyCount);
    }

}
