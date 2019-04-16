package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

public class ChoiceMovie {
    public Movie movie;
    private int member;
    private LocalDateTime time;

    public ChoiceMovie(Movie movie,LocalDateTime time) {
        this.movie = movie;
        this.time = time;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public LocalDateTime getLocalDateTime(){
        return time;
   }

    @Override
    public String toString() {
        return movie.getMovieinForm()+"시작시간:"+ DateTimeUtils.format(time)+"\n"+"예약인원:"+member+"\n";
    }
}
