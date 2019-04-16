package domain;

public class Reserve {
    private  Movie movie;
    private PlaySchedule schedule;
    private int person;
    public Reserve(Movie movie, PlaySchedule schedule , int person){
        this.movie = movie;
        this.schedule = schedule;
        this.person = person;
    }
}
