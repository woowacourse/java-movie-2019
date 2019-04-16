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


    public boolean isRangeWithinOneHour(MovieBookingInfo movieBookingInfo) {
        return this.playSchedule.withinRangeOneHour(movieBookingInfo.getPlaySchedule());
    }

    public PlaySchedule getPlaySchedule() {
        return playSchedule;
    }

    public void reserve() {
        playSchedule.reserve();

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


