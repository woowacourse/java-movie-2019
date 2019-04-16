package domain;

public class MovieReservation {
    private int movieId;
    private int scheduleIndex;
    private int personCount;
    public MovieReservation(int movieNumber, int scheduleIndex, int personCount){
        this.movieId = movieNumber;
        this.scheduleIndex = scheduleIndex;
        this.personCount = personCount;
    }

    public boolean isSameReservation(MovieReservation reservation){
        return (movieId == reservation.getMovieId()) && (scheduleIndex == reservation.getScheduleIndex());
    }

    public void increaseCount(int count){
        personCount += count;
    }
    public int getMovieId(){
        return movieId;
    }
    public int getScheduleIndex(){
        return scheduleIndex;
    }
    public int getPersonCount(){
        return personCount;
    }
}
