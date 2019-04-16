package domain;

public class Reservation {
    private Movie movie;
    private PlaySchedule playSchedule;
    private int theNumberOfPerson;

    public Reservation(Movie movie, PlaySchedule playSchedule, int theNumberOfPerson) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.theNumberOfPerson = theNumberOfPerson;
    }

    public void checkOneHourGap(Reservation reservation){
        if(reservation.calcTimeGapOverOneHour(playSchedule)){
            throw new IllegalArgumentException("1시간 차이의 영화 시간표를 골라주세요.");
        }
    }

    private boolean calcTimeGapOverOneHour(PlaySchedule playSchedule){
        return playSchedule.checkOneHourGapWithOthers(playSchedule);
    }

    public int calcMoviePrice(){
        return movie.getPrice() * theNumberOfPerson;
    }

    @Override
    public String toString() {
        return "예약 내역" + "\n" +
                movie.toStringOnlyMovieField() +
                playSchedule.toStringOnlyStartDateTime() +
                "예약인원 : " + theNumberOfPerson + "명" + "\n";
    }
}
