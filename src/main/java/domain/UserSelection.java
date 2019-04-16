package domain;

public class UserSelection {
    private final int movieId;
    private final int movieTime;
    private final int noOfPerson;

    protected UserSelection(int movieId, int movieTime, int noOfPerson) {
        this.movieId = movieId;
        this.movieTime = movieTime;
        this.noOfPerson = noOfPerson;
    }
}
