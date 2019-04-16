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
    public void printReserverInformation(){
        movie.printMovieInformation();
        schedule.printSchedule();
        System.out.println("예약 인원 " + person);
    }
    public PlaySchedule getSchedule(){
        return this.schedule;
    }
}
