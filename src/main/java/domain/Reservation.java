package domain;

/**
 * 예약 관리 객체
 *
 * @version 1.0(2019.04.16)
 * @author jongyoon Kim
 */
public class Reservation {
    private static final char NEW_LINE = '\n';

    private final Movie movie;
    private final PlaySchedule playSchedule;
    private final int reservationNum;

    public Reservation(Movie movie,
                       PlaySchedule playSchedule, int reservationNum){
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.reservationNum = reservationNum;
    }

    @Override
    public String toString(){
        return  movie.movieInfoToString() + NEW_LINE
                + playSchedule.toString() + NEW_LINE
                + "예약인원: " + reservationNum + "명";
    }
}
