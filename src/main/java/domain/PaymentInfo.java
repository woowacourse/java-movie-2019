package domain;

public class PaymentInfo {
    private Movie movie;
    private PlaySchedule playSchedule;
    private int countOfUser;

    public PaymentInfo(Movie movie, int timeNumber, int countOfUser) {
        this.movie = movie;
        this.playSchedule = movie.getPlaySchedules(timeNumber);
        this.countOfUser = countOfUser;
    }

    public Movie getMovie() {
        return movie;
    }

    public PlaySchedule getPlaySchedule() {
        return playSchedule;
    }

    public int getCountOfUser() {
        return countOfUser;
    }
}
