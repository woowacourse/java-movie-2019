package domain;

public class Reservation {

    private int movieId;
    private int moviePlaySchedule;
    private int peopleNumberOfResrvation;

    public Reservation(int movieId, int moviePlaySchedule, int peopleNumberOfResrvation){
        this.movieId = movieId;
        this.moviePlaySchedule = moviePlaySchedule;
        this.peopleNumberOfResrvation = peopleNumberOfResrvation;
    }

}