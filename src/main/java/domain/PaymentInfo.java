package domain;

public class PaymentInfo {
    Movie movie;
    PlaySchedule playSchedule;
    int countOfUser;

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
