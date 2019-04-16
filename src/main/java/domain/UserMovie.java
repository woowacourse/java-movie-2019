package domain;

public class UserMovie {
    private int movieId;
    private int timeTableId;
    private int peopleCount;

    UserMovie(int movieId, int timeTableId, int peopleCount){
        this.movieId = movieId;
        this.timeTableId = timeTableId;
        this.peopleCount = peopleCount;
    }
}
