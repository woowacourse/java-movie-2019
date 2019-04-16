package domain;


public class Booking {
    private static final char NEW_LINE = '\n';

    private Movie movie;
    private PlaySchedule playSchedule;
    private int numberOfPeople;

    public Booking(Movie movie, int playSchedule, int numberOfPeople) {
        this.movie = movie;
        validatePlaySchedule(playSchedule);
        validateNumberOfPeople(playSchedule, numberOfPeople);
        this.playSchedule = movie.getPlaySchedule(playSchedule);
        this.numberOfPeople = numberOfPeople;
    }

    private void validateNumberOfPeople(int playSchedule, int numberOfPeople) {
        if (!movie.isThereCapacity(playSchedule, numberOfPeople))
            throw new IllegalArgumentException("충분한 인원이 안됩니다. 다시 예매해주세요.");
    }

    private void validatePlaySchedule(int playSchedule) {
        if (!movie.isTherePlaySchedule(playSchedule))
            throw new IllegalArgumentException("해당 시간표는 없습니다. 다시 예매해주세요.");
    }

    public PlaySchedule getPlaySchedule() {
        return playSchedule;
    }

    public int getTotalPrice() {
        return movie.getPrice()*numberOfPeople;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(movie.getMovieInfo())
                .append(playSchedule.getInfo() + NEW_LINE)
                .append("예약인원: " + numberOfPeople + "명" + NEW_LINE);

        return sb.toString();
    }
}
