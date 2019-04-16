package domain;

public class ReservateInformation {
    PlaySchedule playSchedule;
    Movie movie;
    ReservePeople reservePeople;

    public ReservateInformation(PlaySchedule playSchedule, Movie movie,ReservePeople reservePeople){
        this.playSchedule = playSchedule;
        this.movie = movie;
        this.reservePeople = reservePeople;
    }

    public Movie getMovie() {
        return movie;
    }

    public ReservePeople getReservePeople() {
        return reservePeople;
    }

    public PlaySchedule getPlaySchedule() {
        return playSchedule;
    }

    public int getWholePrice(){
        return this.getMovie().getPrice() * this.reservePeople.getReservePeople();
    }
}
