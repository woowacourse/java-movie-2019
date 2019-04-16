package domain;

/**
 * @author delf
 */
public class MovieBookingInfo {
    final String NEW_LINE = "\n";
    final String START_TIME_MESSAGE = "시작시간: ";
    final String NUM_PEOPLE_MESSAGE = "예약인원: ";

    private Movie movie;
    private PlaySchedule playSchedule;
    private int number;

    public MovieBookingInfo(Movie movie, PlaySchedule playSchedule, int number) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.number = number;
    }

    public int getPrice() {
        return movie.getPrice() * number;
    }

    public Movie getMovie() {
        return movie;
    }

    public boolean isRangeWithinOneHour(PlaySchedule playSchedule) {
        return this.playSchedule.withinRangeOneHour(playSchedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(movie.getBasicMoveInfo()).append(NEW_LINE);
        sb.append(START_TIME_MESSAGE).append(playSchedule.getStartDateTime()).append(NEW_LINE);
        sb.append(NUM_PEOPLE_MESSAGE).append(number).append("명");

        return sb.toString();
    }
}


