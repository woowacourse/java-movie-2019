package domain;

import static utils.DateTimeUtils.format;

public class Reservation {

    private int movieId;
    private int moviePlaySchedule;
    private int peopleNumberOfResrvation;

    public Reservation(int movieId, int moviePlaySchedule, int peopleNumberOfResrvation){
        this.movieId = movieId;
        this.moviePlaySchedule = moviePlaySchedule;
        this.peopleNumberOfResrvation = peopleNumberOfResrvation;
    }

    public String toString(){
        Movie movie = MovieRepository.getMovie(movieId);
        PlaySchedule playSchedule = movie.getPlaySchedule(moviePlaySchedule);
        return movie.getMovieInfo() + "시작시간: " + playSchedule.getFormatStartDateTime() + "\n" +
                "예약 인원: " + peopleNumberOfResrvation + "명" + "\n";

    }

}