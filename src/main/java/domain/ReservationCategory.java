package domain;


public class ReservationCategory {
    private static final char NEW_LINE = '\n';

    private final Movie movie;
    private final String startDateTime;
    private final int numberOfPerson;

    public ReservationCategory(Movie movie, String startDateTime, int numberOfPerson){
        this.movie = movie;
        this.startDateTime = startDateTime;
        this.numberOfPerson = numberOfPerson;
    }

    @Override
    public String toString() {
        return movie.getId() + " - " + movie.getName() + ", " + movie.getPrice() + "원" + NEW_LINE
                + "시작시간: " + startDateTime + NEW_LINE
                + "예약인원: " + numberOfPerson + NEW_LINE;
    }

    public int reservedPrice(){
        return (movie.getPrice() * numberOfPerson);
    }
}
