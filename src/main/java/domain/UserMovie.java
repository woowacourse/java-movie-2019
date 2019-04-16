package domain;

public class UserMovie {
    private int movieId;
    private int timeTableId;
    private int peopleCount;

    public UserMovie(int movieId, int timeTableId, int peopleCount){
        this.movieId = movieId;
        this.timeTableId = timeTableId;
        this.peopleCount = peopleCount;
    }

    public int getTimeId(){
        return timeTableId;
    }
}
