package domain;

public class ReserveMovie {
    private static final char NEW_LINE = '\n';

    private final Movie movie;
    private final PlaySchedule playSchedule;
    private final int numOfPerson;

    public ReserveMovie(Movie moive, PlaySchedule playSchedule, int numOfPerson ) {
        this.movie = moive;
        this.playSchedule = playSchedule;
        this.numOfPerson = numOfPerson;
    }

    public ReserveMovie getReserveMovie() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(playSchedule);
        return movie.getId() + " - " + movie.getName() + ", " + movie.getPrice() + "원" + NEW_LINE
                + sb.toString() + "예약 인원: " + this.numOfPerson + "명";
    }

    public int getNumOfPerson() {
        return this.numOfPerson;
    }
}
