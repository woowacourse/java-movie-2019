package domain;

public class SelectMovie {

    private final Movie movie;
    private final int time;
    private final int peopleNum;

    public SelectMovie(Movie movie, int time, int peopleNum) {
        this.movie = movie;
        this.time = time;
        this.peopleNum = peopleNum;
    }
}
